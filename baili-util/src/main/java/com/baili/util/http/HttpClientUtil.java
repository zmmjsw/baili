package com.baili.util.http;


import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;

import com.baili.util.UUIDUtil;

/**
* @ClassName: HttpClientBMLUtil 
* @Description: TODO(接口访问) 
* @author Yuanquan
* @date 2018年4月10日 下午4:02:24
 */
public class HttpClientUtil {
	
	/**
	* @Title: getHeaders 
	* @Description: TODO(头设置) 
	* @param @return    设定文件 
	* @return HttpHeaders    返回类型
	* @author Yuanquan
	* @throws
	 */
	public static HttpHeaders getHeaders(){
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/x-www-form-urlencoded");
		return headers;
	}
	
	/**
	* @Title: addAauthorization 
	* @Description: TODO(测试使用固定用户账号信息) 
	* @param @param data
	* @param @return    设定文件 
	* @return LinkedMultiValueMap<String,String>    返回类型
	* @author Yuanquan
	* @throws
	 */
	 public static LinkedMultiValueMap<String, String> addAauthorization(String data){
	    	LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		    map.add("loginName", "rest");//分系统帐号
		    map.add("loginPassword", "123");//分系统密码
		    map.add("invokeUserId", "alex");//登入分系统调用接口的使用者帐号
		    map.add("requestId", UUIDUtil.uuid());//调用接口随机码
		    map.add("param", data);//接口需要用到的参    
		    return map;
	    }
}
	
