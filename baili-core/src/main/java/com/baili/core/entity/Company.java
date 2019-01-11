package com.baili.core.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
* @ClassName: Company 
* @Description: TODO(公司表) 
* @author zhumingming 
* @date 2018年11月29日 下午4:26:28 
*
 */
@Entity
@Table(name = "b_company")
public class Company implements Serializable{


	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "公司名称")
	private String companyName;// 公司名称

	@ApiModelProperty(value = "邮箱")
	private String email;// 邮箱
	
	@ApiModelProperty(value = "电话")
	private String phone;// 电话
	
	@ApiModelProperty(value = "地址")
	private String address;//地址
	
	@ManyToOne
	@ApiModelProperty(value = "用户")
	private List<User> users;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}