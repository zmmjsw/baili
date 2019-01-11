package com.baili.pms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.baili.core.entity.BastEntity;
/**
 * 
* @ClassName: AttributeKey 
* @Description: TODO(规格属性健) 
* @author zhumingming 
* @date 2018年12月3日 上午11:27:40 
*
 */
@Entity
@Table(name = "b_attribute_key")
public class AttributeKey extends BastEntity{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	private Long categoryId;//分类id
	
	private String attributeName;//属性名字
	
	private Integer nameSeq;//排序
	
	private Category category;
	
	private List<AttributeValue> avList;//值列表
	
	
	
	

	public List<AttributeValue> getAvList() {
		return avList;
	}

	public void setAvList(List<AttributeValue> avList) {
		this.avList = avList;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public Integer getNameSeq() {
		return nameSeq;
	}

	public void setNameSeq(Integer nameSeq) {
		this.nameSeq = nameSeq;
	}
	
	

}
