package org.baili.gateway.common.filter;



import java.net.URI;

import org.apache.commons.lang.StringUtils;
import org.baili.gateway.common.exception.MyException;
import org.baili.gateway.common.exception.ResponseStatusEnum;
import org.baili.gateway.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
/**
 * 
* @ClassName: AuthGlobalFilterFilter 
* @Description: TODO(在这里拦截过滤) 
* @author zhumingming 
* @date 2018年11月22日 上午9:13:52 
*
 */
@Component
public class AuthGlobalFilterFilter implements GlobalFilter, Ordered{
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	

	@Override
	public int getOrder() {
		
		return 0;
	}

	/**
	 * 
	* @Title: filter 
	* @Description: TODO(在此进行全局拦截处理) 
	* @param @param exchange
	* @param @param chain
	* @param @return    设定文件 
	* @throws
	 */
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		URI uri = request.getURI();
		if(uri!=null) {
		if(isPath(uri.getPath())) {
			MultiValueMap<String, HttpCookie> cookies = request.getCookies();
			HttpCookie first = cookies.getFirst("hayek.session.id");
			if(first==null) {
				throw new MyException(ResponseStatusEnum.UNAUTHORIZED);
			}
			String value = first.getValue();
			RedisUtil ru=new RedisUtil();
			ru.setRedisTemplate(stringRedisTemplate);
			String string = ru.get(value);
			if(StringUtils.isEmpty(string)) {
					throw new MyException(ResponseStatusEnum.UNAUTHORIZED);
			}
		}
		}
		return chain.filter(exchange);
	}
	
	private boolean isPath(String path) {
	
		if(path.indexOf("swagger")>-1) {
			return false;
		}
		if(path.indexOf("v2")>-1) {
			return false;
		}
		if(path.indexOf("login")>-1) {
			return false;
		}
		if(path.indexOf("csrf")>-1) {
			return false;
		}
		int n=1;
		String b=path.substring(path.length()-n,path.length());
		if("/".equals(b)) {
			return false;
		}
		return true;
		
	}

}
