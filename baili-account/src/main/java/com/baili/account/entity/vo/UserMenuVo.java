package com.baili.account.entity.vo;

import java.util.List;

import com.baili.core.entity.Permissions;

import io.swagger.annotations.ApiModelProperty;

public class UserMenuVo {
	
	@ApiModelProperty(value="用户姓名")
	private String name;
	
	@ApiModelProperty(value="用户公司")
	private String companyName;
	
	private List<Permissions> Permissionss;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Permissions> getPermissionss() {
		return Permissionss;
	}

	public void setPermissionss(List<Permissions> permissionss) {
		Permissionss = permissionss;
	}
	
	
	
	

}
