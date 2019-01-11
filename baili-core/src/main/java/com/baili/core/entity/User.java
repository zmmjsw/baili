package com.baili.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
* @ClassName: User 
* @Description: TODO(用户表) 
* @author zhumingming 
* @date 2018年11月23日 下午3:08:38 
*
 */
@Entity
@Table(name = "b_user")
public class User extends BastEntity{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "公司id")
	private Long companyId;// 公司id
	
	@ApiModelProperty(value = "公司")
	@ManyToOne
	private Company company;
	
	@ApiModelProperty(value = "姓名，名称")
	private String name;// 名称，姓名

	@ApiModelProperty(value = "账号")
	private String userName;// 账号

	@ApiModelProperty(value = "密码")
	private String passWord;// 密码

	@ApiModelProperty(value = "邮箱")
	private String email;// 邮箱

	@ApiModelProperty(value = "手机")
	private String mobilePhone;// 手机

	@ApiModelProperty(value = "审核状态，用户状态")
	private String status; // 审核状态

	@ApiModelProperty(value = "用户类型，企业，个人")
	private String userType;// 客户类型 //企业 个人

	@ApiModelProperty(value = "账号类型,管理，客户")
	private String type;// 账号类型 管理员，客户等

	@ApiModelProperty(value = "角色列表")
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = Lists.newArrayList();
	
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}




	
	
}
