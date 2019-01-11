package com.baili.core.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


/**
 * 
 * @ClassName: Department
 * @Description: TODO(部门)
 * @author zhumingming
 * @date 2018年12月6日 下午5:16:25
 *
 */
@Entity
@Table(name = "b_department")
public class Department extends BastEntity {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "排序")
	private Integer num;
	
	@ApiModelProperty(value = "父部门id")
	private Long pid;

	@ApiModelProperty(value = "简称")
	private String simpleName;

	@ApiModelProperty(value = "全称")
	private String fullName;
	
	@ApiModelProperty(value = "提示")
	private String tips;


	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}


	
	
	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

}
