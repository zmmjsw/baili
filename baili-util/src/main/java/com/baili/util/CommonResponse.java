package com.baili.util;
import java.io.Serializable;

public class CommonResponse  implements Serializable {

    private static final long serialVersionUID = 5576237395711742681L;
    
	// 是否成功"是否成功[true:成功，false:失败]
	private boolean success;;

	// 返回编码 [200:成功，500：系统错误,请稍后重试或者联系管理员]
	private long code;  
	
	// 错误类型 "是否成功[true:成功，false:失败]
	private String desc;  // 
	
	//列表信息
	private Object obj = null; 
	
	// 是否成功[true:成功，false:失败]"
	private String content;
	
	public CommonResponse() {
		this.success = false;
		this.code = 500;
		this.desc ="错误信息";
	}
	
	public CommonResponse(long code,String desc) {
		this.code = code;
		this.desc = desc;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommonResponse [success=" + success + ", code=" + code + ", desc=" + desc + ", obj=" + obj
				+ ", content=" + content + "]";
	}
	
	
	
	
}
