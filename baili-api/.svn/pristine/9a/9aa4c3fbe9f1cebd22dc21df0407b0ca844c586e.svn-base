package com.baili.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
* @ClassName: AlibabaApiController 
* @Description: TODO(Alibaba授权控制类) 
* @author Alex-晓帅
* @date 2018年11月12日 下午1:29:45
 */
public class AlibabaOAuthApiController {
	
		/**
		* @Title: listnote 
		* @Description: TODO(跳转至1688获取授权码界面) 
		* @param @param clientId
		* @param @param redirectUri
		* @param @return    设定文件 
		* @author Aelx-晓帅
		* @return Object    返回类型 
		* @throws
		 */
		@ApiOperation(value="1688授权获取授权码",httpMethod="POST",notes="1688授权获取授权码")
		@RequestMapping(value="/getAuthCode",method=RequestMethod.POST)
		public @ResponseBody Object listnote(@ApiParam(value="客户ID") @RequestParam(required=true) String clientId,
				@ApiParam(value="重定向地址") @RequestParam(required=true) String redirectUri){
				 // String redirectUri="http://101.200.1.152/code/authCode.html";//这个是项目中自定义的codehtml接收界面
	            String site = "1688";
	            String state = "json";
	            Map<String, String> params = new HashMap<String, String>();
	            params.put("client_id", clientId);
	            params.put("site", site);
	            params.put("redirect_uri","http://gw.api.alibaba.com/auth/authCode.htm");
	            params.put("state", state);
	            String url = "https://auth.1688.com/oauth/authorize?client_id="+clientId+"" +
	            		"&site="+site+"&redirect_uri="+redirectUri+"&state="+state;
	             //将其跳转至另一个界面// window.open('${url}');
				return  url;
		}
}

