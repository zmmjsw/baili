package com.baili.account.common.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.baili.account.service.UserService;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.common.exception.MyException;
import com.baili.core.entity.Permissions;
import com.baili.core.entity.Role;
import com.baili.core.entity.User;

/**
 * 
 * @ClassName: MyShiroRealm
 * @Description: TODO(授权认证)
 * @author zhumingming
 * @date 2017年12月7日 下午5:45:32
 *
 */
public class MyShiroRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;
	
	@SuppressWarnings("rawtypes")
	@Resource
    private RedisTemplate redisTemplate;
	
    @Resource
	private StringRedisTemplate stringRedisTemplate;
	
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User userInfo = (User) principals.getPrimaryPrincipal();
		for (Role role : userInfo.getRoles()) {
			authorizationInfo.addRole(role.getName());
			for (Permissions p : role.getPermissions()) {
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}

	/**
	 * 
	* @Title: doGetAuthenticationInfo 
	* @Description: TODO(用户认证) 
	* @param @param token
	* @param @return
	* @param @throws AuthenticationException    设定文件 
	* @throws
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户的输入的账号.
		String userName = (String) token.getPrincipal();
		User userInfo = userService.findUserByUserName(userName);
		
		if (userInfo == null) {
			throw new MyException(ResponseStatusEnum.LOGIN_ERROR);
		}
		 // 用户名
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo,
				 // 密码
				userInfo.getPassWord(),
				// salt=username+salt  盐值  这里用用户名加盐
				ByteSource.Util.bytes(userInfo.getName()), 
				// realm name
				getName() 
		);
		// 当验证都通过后，把用户信息放在session里
		//Session session = SecurityUtils.getSubject().getSession();
		//session.setAttribute("userSession", userInfo);
		//session.setAttribute("userSessionId", userInfo.getId());
		return authenticationInfo;
	}

}