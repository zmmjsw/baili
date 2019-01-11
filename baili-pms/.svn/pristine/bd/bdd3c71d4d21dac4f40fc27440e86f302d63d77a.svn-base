package com.baili.pms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.baili.core.entity.BastEntity;
/**
 * 
* @ClassName: Category 
* @Description: TODO(商品类别表) 
* @author zhumingming 
* @date 2018年11月30日 下午3:07:59 
*
 */
@Entity
@Table(name = "b_category")
public class Category extends BastEntity{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	private String categoryName;//类别名称
	
	private String code;//类别编号
	
	private Long parentId;//父id                            
	
	
	private List<AttributeKey> akList;//属性列表
	
	

	public List<AttributeKey> getAkList() {
		return akList;
	}

	public void setAkList(List<AttributeKey> akList) {
		this.akList = akList;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	
	

}
