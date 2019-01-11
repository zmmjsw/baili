package com.baili.api.manage.token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.baili.api.common.service.ApiCallService;
/**
* @ClassName: AlibabaApiController 
* @Description: TODO(Alibaba授权) 
* @author Alex-晓帅
* @date 2018年11月12日 下午1:29:45
 */
@Component
public class AlibabaOAuthApi{
	/**
	 * web 授权流程
	 * 1,用户使用app，访问在 1688 的隐私数据
	 * 2,app发起授权请求
	 * 3,用户输入用户名密码，并确认授权
	 * 4,返回临时授权码code给app 
	 * 5,使用code获取令牌（注：如果超过code有效期（2分钟）或者已经使用code获取了一次令牌，code都将失效，需要返回第二步重新获取code）
	 * 6,返回令牌 （说明：resource_owner为登录id，memberId为会员接口id，aliId为阿里巴巴集团统一的id，refresh_token_timeout表示refreshToken的过期时间）
	 * 7,使用令牌访问用户隐私数据 (例如访问以下api ： http://gw.open.1688.com/openapi/param2/1/cn.alibaba.open/member.get/1?memberId=xxx&access_token=ACCESS_TOKEN&_aop_signature=SIGENATURE )
	 */
	@Value("${alibaba.token.clientid}")
	private String clientid;
	
	@Value("${alibaba.token.appSecretKey}")
	private String appSecretKey;

	@Value("${alibaba.token.alitoken}")
	private String alitoken;
		/**
		* @Title: listnote 
		* @Description: TODO(获取权码code) 
		* @param @param clientId
		* @param @param redirectUri  目前默认的为ali提供的页面
		* @param @return    设定文件 
		* @author Aelx-晓帅
		* @return Object    返回类型 
		* @throws
		 */
		public  String getoauthcode(String redirectUri){
	            String site = "1688";
	            String state = "json";
	            Map<String, String> params = new HashMap<String, String>();
	            params.put("client_id", clientid);
	            params.put("site", site);
	            params.put("redirect_uri","https://authhz.alibaba.com/auth/authCode.htm");
	            params.put("state", state);
	            String url = "https://auth.1688.com/oauth/authorize?client_id="+clientid+"" +
	            		"&site="+site+"&redirect_uri="+redirectUri+"&state="+state;
				return  url;
		}
		/**
		* @Title: getaccesstoken 
		* @Description: TODO(获取授权令牌) 
		* getToken接口参数说明：
		*	a) grant_type为授权类型，使用authorization_code即可
		*	b) need_refresh_token为是否需要返回refresh_token，如果返回了refresh_token，原来获取的refresh_token也不会失效，除非超过半年有效期
		*	c) client_id为app唯一标识，即appKey
		*	d) client_secret为app密钥
		*	e) redirect_uri为app入口地址
		*	f) code为授权完成后返回的一次性令牌
		*	g) 调用getToken接口不需要签名
		* @param @return    设定文件 
		* @author Aelx-晓帅
		* @return Object    返回类型 
		* accessToken（超过10小时）将会过期
		* @throws
		 */
		public  String  getaccesstoken(String code){
			String urlHead = "https://gw.open.1688.com/openapi/";
			String urlPath = "param2/1/system.oauth2/getToken/" + clientid;
            Map<String, String> params = new HashMap<String, String>();
            params.put("grant_type", "authorization_code");//通过code获取accesstokens
			params.put("need_refresh_token", "true");
			params.put("client_id", clientid);
			params.put("client_secret", appSecretKey);
			params.put("redirect_uri","https://authhz.alibaba.com/auth/authCode.htm");
			params.put("code", code);
            return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, params);
	   }
		/**
		 *refreshToken换取accessToken流程详解
		* @Title: refreshToken 
		* @Description: TODO(重新通过reshtoken刷新获取accessToken) 
		* @author Aelx-晓帅
		* 如果refreshToken已经超过了半年的有效期，用户修改密码，用户订购到期或者用户通过取消授权工具取消了对app的授权,那么都需要用户重新授权获取refreshToken
		* accessToken（超过10小时）将会过期  通过refreshtoken刷新获取
		 */
		public  String  refreshTokentoaccesstoken(String reshtoken,String accesstoken){
			String urlHead = "https://gw.open.1688.com/openapi/";
			String urlPath = "param2/1/system.oauth2/getToken/" + clientid;
            Map<String, String> params = new HashMap<String, String>();
            params.put("grant_type", "refresh_token");//通过refresh_token获取accesstokens
			params.put("client_id", clientid);
			params.put("client_secret", appSecretKey);
			params.put("refresh_token",reshtoken);//长令牌
			params.put("access_token",accesstoken);//调用令牌
            return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, params);
	   }
		/**
		 * 换取新的refreshToken流程详解
		 * 如果当前时间离refreshToken过期时间在30天以内，那么可以调用postponeToken接口换取新的refreshToken；否则会报错。
		 * refreshToken过期了，用户再次通过应用市场进入应用主页时授权一次即可(重新授权)
		 * refresh_token参数表示当前使用的refreshToken，如果refreshToken的有效期和当前时间的差值小于30天，那么调用此接口后当前使用的refreshToken失效，返回一个新的refreshToken
		 */
		public  String  getrefreshToken(String reshtoken){
			String urlHead = "https://gw.open.1688.com/openapi/";
			String urlPath = "param2/1/system.oauth2/postponeToken/" + clientid;
            Map<String, String> params = new HashMap<String, String>();
			params.put("client_id", clientid);
			params.put("client_secret", appSecretKey);
			params.put("refresh_token",reshtoken);
            return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, params);
	   }
		/**
		 * 账号管理
		 * 1,查询所有账号
		 * 2,批量查询子账号 subaccount.auth.list
		 * 3,批量添加子账号授权 subaccount.auth.add
		 * 4,批量取消子账号授权 subaccount.auth.cancel
		 */
		
		/**
		 * 1
		* @Title: getAccountList 
		* @Description: TODO(获取主账号下面所有子账号) 
		* @param @param access_token
		* @author Aelx-晓帅
		 */
		public String getoauthAccountList(String access_token){
			 String urlHead="https://gw.open.1688.com/openapi/";
			 String urlPath="param2/1/com.alibaba.account/alibaba.subAccount.list/"+clientid;
			 HashMap<String, String> map=new HashMap<String, String>();
			 map.put("access_token",access_token);
			 map.put("client_id", clientid);
			 map.put("client_secret", appSecretKey);
			 return  ApiCallService.callApiTest(urlHead,urlPath,appSecretKey,map);
		}
		/**
		 * 2
		* @Title: oauth2subaccountauthlist 
		* @Description: TODO(批量查询子账号授权情况) 
		* @author Aelx-晓帅
		 */
		public  String  subaccountauthlist( ArrayList<String>  strlist,String access_token){
			 String urlHead="https://gw.open.1688.com/openapi/";
			 String urlPath="param2/1/system.oauth2/subaccount.auth.list/"+clientid;
			 HashMap<String, String> map=new HashMap<String, String>();
			 map.put("access_token", access_token);
			 map.put("client_id", clientid);
			 map.put("client_secret", appSecretKey);
			 map.put("subUserIdentityList",JSON.toJSONString(strlist));
			 return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		}
		/**
		 * 3
		* @Description: TODO(批量添加子账号授权) 
		* @author Aelx-晓帅
		 */
		public  String subaccountauthadd(String access_token,ArrayList<String> loginids){
			 String urlHead="https://gw.open.1688.com/openapi/";
			 String urlPath="param2/1/system.oauth2/subaccount.auth.add/"+clientid;
			 HashMap<String, String> map=new HashMap<String, String>();
			 map.put("access_token",access_token);//父账号令牌
			 map.put("client_id", clientid);
			 map.put("client_secret", appSecretKey);
			 map.put("subUserIdentityList",JSON.toJSONString(loginids));
			 return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		}
		/**
		* @Title: oauth2subaccountcancel 
		* @Description: TODO(取消子单号授权) 
		* @author Aelx-晓帅
		 */
		public String subaccountauthcancel(String access_token,ArrayList<String> loginids){
			 String urlHead="https://gw.open.1688.com/openapi/";
			 String urlPath="param2/1/system.oauth2/subaccount.auth.cancel/"+clientid;
			 HashMap<String, String> map=new HashMap<String, String>();
			 map.put("access_token", access_token);
			 map.put("client_id", clientid);
			 map.put("client_secret", appSecretKey);
			 map.put("subUserIdentityList",JSON.toJSONString(loginids));
			 return  ApiCallService.callApiTest(urlHead, urlPath, appSecretKey, map);
		}
}

