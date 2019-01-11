package com.baili.sms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.baili.core.entity.BastEntity;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
* @ClassName: Shop 
* @Description: TODO(店铺表) 
* @author zhumingming 
* @date 2018年12月10日 下午3:39:03 
*
 */

@Entity
@Table(name = "b_shop")
public class Shop extends BastEntity{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="店铺名字")
	private String shopName;
	
	@ApiModelProperty(value="店铺类型")
	private String shopType;
	
	@ApiModelProperty(value="是否开启")
	private boolean enable;//是true,否false
	
	private String shopAtive;//门店状态	1:营业中 0：休息中		
	
	private String shopStatus;//	门店状态	-2:已停止 -1:拒绝 0：未审核 1:已审核
	
	@ApiModelProperty(value="token")
	private String accessToken;
	
	@ApiModelProperty(value="刷新token")
	private String refreshToken;
	

	
	
	public String getShopAtive() {
		return shopAtive;
	}

	public void setShopAtive(String shopAtive) {
		this.shopAtive = shopAtive;
	}

	public String getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(String shopStatus) {
		this.shopStatus = shopStatus;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	
	
	
	

}
