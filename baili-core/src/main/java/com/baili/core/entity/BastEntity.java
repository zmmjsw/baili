package com.baili.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName: BastEntity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年5月31日 下午3:19:35
 *
 */
@ApiModel
@MappedSuperclass
public class BastEntity implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "修改时间")
	private Date updateTime;

	@Version
	protected Long version;

	@ApiModelProperty(value = "创建人")
	private String createdBy;
	
	@ApiModelProperty(value="创建人id")
	private Long createdById;//创建人id

	@ApiModelProperty(value = "修改人")
	private String updatedBy;
	
	
	@ApiModelProperty(value = "创建人公司")
	private String createdByCompany;
	
	@ApiModelProperty(value="创建人公司id")
	private Long createdByCompanyId;//创建人公司id


	public String getCreatedByCompany() {
		return createdByCompany;
	}

	public void setCreatedByCompany(String createdByCompany) {
		this.createdByCompany = createdByCompany;
	}

	public Long getCreatedByCompanyId() {
		return createdByCompanyId;
	}

	public void setCreatedByCompanyId(Long createdByCompanyId) {
		this.createdByCompanyId = createdByCompanyId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}

	
	
}
