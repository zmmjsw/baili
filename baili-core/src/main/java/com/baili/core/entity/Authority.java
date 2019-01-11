package com.baili.core.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
* @ClassName: Authority 
* @Description: TODO(操作权限) 
* @author zhumingming 
* @date 2018年12月11日 上午11:23:34 
*
 */

@Entity
@Table(name = "b_authority")
public class Authority implements Serializable{
	
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "操作权限名称")
	@Column(unique = true)
	private String name;// 名称
	
	@ApiModelProperty(value = "操作权限标识")
	private String button;
	
	
	@ApiModelProperty(value = "操作权限描述")
	private String buttonDescription;
	
	
	@ApiModelProperty(value = "角色列表")
	@ManyToMany
	@JoinTable(name = "role_authority", joinColumns = @JoinColumn(name = "authority_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	
	@ApiModelProperty(value = "资源权限")
	private Permissions permissions;
	
	@ApiModelProperty(value = "资源权限Id")
	private Long permissionsId;
	
	

	public Permissions getPermissions() {
		return permissions;
	}


	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}


	public Long getPermissionsId() {
		return permissionsId;
	}


	public void setPermissionsId(Long permissionsId) {
		this.permissionsId = permissionsId;
	}


	public String getButton() {
		return button;
	}


	public void setButton(String button) {
		this.button = button;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getButtonDescription() {
		return buttonDescription;
	}


	public void setButtonDescription(String buttonDescription) {
		this.buttonDescription = buttonDescription;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	

}
