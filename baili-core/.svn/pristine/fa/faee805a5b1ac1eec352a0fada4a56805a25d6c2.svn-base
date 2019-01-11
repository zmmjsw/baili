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
* @ClassName: Permissions 
* @Description: TODO(权限表) 
* @author zhumingming 
* @date 2018年12月11日 上午11:05:23 
*
 */


@Entity
@Table(name = "b_permissions")
public class Permissions implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "权限名称")
	@Column(unique = true)
	private String name;// 名称


	private String action;// 权限对应的action
	
	@ApiModelProperty(value = "排序,权重")
	private String seq;// 排序，权重

	@Column(columnDefinition = "enum('role','owner')")
	private String relation;// 资源类型，该权限是私有还是角色权限 [menu|button]

	@ApiModelProperty(value = "资源路径")
	private String url;// 资源路径

	@ApiModelProperty(value = "权限字符")
	private String permission;// 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

	@ApiModelProperty(value = "父id")
	private Long parentId;// 父编号

	
	@ApiModelProperty(value = "角色列表")
	@ManyToMany
	@JoinTable(name = "role_permissions", joinColumns = @JoinColumn(name = "permissions_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	
	@ApiModelProperty(value = "操作权限列表")
	private List<Authority> authoritys;
	
	
	
	
	

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public List<Authority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(List<Authority> authoritys) {
		this.authoritys = authoritys;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}



	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

}
