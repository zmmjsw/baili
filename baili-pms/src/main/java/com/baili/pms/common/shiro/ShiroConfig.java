package com.baili.pms.common.shiro;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.baili.core.common.redis.ShiroRedisCacheManager;

import cn.hutool.core.codec.Base64;

/**
 * 
 * @ClassName: ShiroConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2017年12月7日 下午5:54:08
 *
 */
@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/static/**", "anon");
		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/logout", "logout");
		// <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		// <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**", "anon");
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("https://www.baidu.com");

		// 未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 ）
	 * 
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		// 散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashAlgorithmName("md5");
		// 散列的次数，比如散列两次，相当于 md5(md5(""));
		hashedCredentialsMatcher.setHashIterations(2);
		return hashedCredentialsMatcher;
	}


	/**
	 * cookie管理对象
	 *
	 * @return CookieRememberMeManager
	 */
	private CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
		cookieRememberMeManager.setCookie(rememberMeCookie());
		// rememberMe cookie 加密的密钥
		cookieRememberMeManager.setCipherKey(Base64.decode("ZWvohmPdUsAWT3=KpPqda"));
		return cookieRememberMeManager;
	}

	/**
	 * rememberMe cookie 效果是重开浏览器后无需重新登录
	 *
	 * @return SimpleCookie
	 */
	private SimpleCookie rememberMeCookie() {
		// 这里的Cookie的默认名称是 CookieRememberMeManager.DEFAULT_REMEMBER_ME_COOKIE_NAME
		SimpleCookie cookie = new SimpleCookie(CookieRememberMeManager.DEFAULT_REMEMBER_ME_COOKIE_NAME);
		// 是否只在https情况下传输
		cookie.setSecure(false);
		// 设置 cookie 的过期时间，单位为秒，这里为一天
		cookie.setMaxAge(2592000);
		return cookie;
	}

	/**
	 * 缓存管理器的配置
	 * 
	 * @param redisTemplate
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private ShiroRedisCacheManager cacheManager(RedisTemplate template) {
		return new ShiroRedisCacheManager(template);
	}

	@SuppressWarnings("rawtypes")
	@Bean
	public SecurityManager securityManager(RedisTemplate redisTemplate) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 配置 rememberMeCookie 查看源码可以知道，这里的rememberMeManager就仅仅是一个赋值，所以先执行
		securityManager.setRememberMeManager(rememberMeManager());
		// 自定义缓存实现 使用redis
		securityManager.setCacheManager(cacheManager(redisTemplate));
		// 自定义session管理 使用redis
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	/**
	 * session 管理对象
	 *
	 * @return DefaultWebSessionManager
	 */
	private DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		// 设置session超时时间，单位为毫秒
		sessionManager.setGlobalSessionTimeout(1800000);// 设置拆散时间
		sessionManager.setSessionIdCookie(new SimpleCookie("hayek.session.id"));// 设置session的名字
		// 网上各种说要自定义sessionDAO 其实完全不必要，shiro自己就自定义了一个，可以直接使用，还有其他的DAO，自行查看源码即可
		sessionManager.setSessionDAO(new EnterpriseCacheSessionDAO());
		return sessionManager;
	}

	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	@Bean(name = "simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
		// SimpleMappingExceptionResolver r = new SimpleMixInResolver();
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		// 数据库异常处理
		mappings.setProperty("DatabaseException", "databaseError");
		mappings.setProperty("UnauthorizedException", "403");
		// None by default
		r.setExceptionMappings(mappings);
		// No default
		r.setDefaultErrorView("error");
		// Default is "exception"
		r.setExceptionAttribute("ex");
		return r;
	}
}