package com.baili.api.common.service;

import com.baili.util.CommonResponse;
/**
 * 数据解析类
* @ClassName: ApiServiceReadResul 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Alex-晓帅
* @date 2018年11月12日 下午5:54:43
 */
public class ApiServiceReadResul {
	
	public CommonResponse Readreslu(String results){
		CommonResponse aliread=new CommonResponse();
		//异常分析授权问题-其他问题
		if(results.contains("error_description") || results.contains("error_message") || results.contains("error") || results.contains("errorMessage")){
        	aliread.setCode(102);
        	aliread.setDesc(results);
        	aliread.setContent("阿里巴巴接口错误,请联系服务商对接阿里接口");
        	aliread.setSuccess(false);
		}else if(results.contains("Read timed out") || results.contains("gw.open.1688.com")){
			aliread.setCode(101);
        	aliread.setDesc(results);
        	aliread.setContent("超时异常,请查看网络或者稍后再试");
        	aliread.setSuccess(false);
		}else{//正确输出
			aliread.setCode(200);
			aliread.setDesc("解析成功");
			aliread.setContent(results);
			aliread.setSuccess(true);
		}
		return aliread;
	}
}
