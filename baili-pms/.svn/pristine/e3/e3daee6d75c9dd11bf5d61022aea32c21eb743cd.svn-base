package com.baili.pms.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.baili.core.entity.BastEntity;

/**
 * 
* @ClassName: ProductSpecs 
* @Description: TODO(商品规格表，sku) 
* @author zhumingming 
* @date 2018年11月30日 下午6:13:54 
*
 */
@Entity
@Table(name = "b_product_specs")
public class ProductSpecs extends BastEntity{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	private String sku;
	
	private String name;//sku名字
	
	private Long product_id;//skuid
	
	private Product product;//sku内容
	
	private String specs;//规格 字json形式{"内存":"2G","颜色":"红色"}
	
	private String specsSeq;//顺序
	
	
	private BigDecimal  productPrice;//单价
	
	private Integer productStock;//库存
	
	private Integer salesVolume;//库存
	

	
	
	public Integer getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public String getSpecsSeq() {
		return specsSeq;
	}

	public void setSpecsSeq(String specsSeq) {
		this.specsSeq = specsSeq;
	}

	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	

}
