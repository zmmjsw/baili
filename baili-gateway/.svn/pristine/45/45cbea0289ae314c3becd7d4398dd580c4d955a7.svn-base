package org.baili.gateway.common.exception;

/**
 * 
* @ClassName: ResponseStatus 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年6月4日 下午4:07:28 
*
 */
public enum ResponseStatusEnum {
	   UNAUTHORIZED(500, "尚未登录！");
	    private Integer code;
	    private String message;

	    ResponseStatusEnum(Integer code, String message) {
	        this.code = code;
	        this.message = message;
	    }

	    public static ResponseStatusEnum getResponseStatus(String message) {
	        for (ResponseStatusEnum ut : ResponseStatusEnum.values()) {
	            if (ut.getMessage().equals(message)) {
	                return ut;
	            }
	        }
	        return null;
	    }

	    public Integer getCode() {
	        return code;
	    }

	    public String getMessage() {
	        return message;
	    }

}
