package com.baili.sms.common.enums;

public enum ShopEnum {
	ALIBABA("阿里巴巴"),
	JD("京东"),
	TAOBAO("淘宝"),
	
	IN_BUSINESS("营业中"),
	SUSPEND_BUSINESS("休业中"),
	
	HAS_CEASED("已停止"),
	REFUSE("拒绝"),
	UNAUDITED("未审核"),
	AUDITED("已审核");

	private String code;

	ShopEnum(String code) {
		this.code = code;
	}

	public static ShopEnum getResponseStatus(String code) {
		for (ShopEnum ut : ShopEnum.values()) {
			if (ut.getCode().equals(code)) {
				return ut;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

}
