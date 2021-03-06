package com.baili.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baili.core.common.annotation.CompanyAnnotation;
import com.baili.pms.entity.Product;
import com.baili.pms.entity.vo.ProductConditionVo;
import com.baili.pms.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 
* @ClassName: ProductService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年6月1日 下午2:20:50 
*
 */
@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	public void addProduct(Product product) {
		productMapper.insert(product);
	}

	public void deleteProduct(Long id) {
		productMapper.deleteByPrimaryKey(id);
		
	}

	public void updateProduct(Product product) {
		productMapper.updateByPrimaryKeySelective(product);
	}

	@CompanyAnnotation
	public Product findProductById(Long id) {
		return productMapper.selectByPrimaryKey(id);
	}

	/**
	 * 
	* @Title: findProducts 
	* @Description: TODO(根据条件分页查询) 
	* @return PageInfo<Product>    返回类型
	 */
	public PageInfo<Product> findProducts(ProductConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<Product> Products = productMapper.findPageBreakByCondition(vo);
		PageInfo<Product> bean = new PageInfo<Product>(Products);
		bean.setList(Products);
		return bean;
	}

	
	/*public Product findProductByExample(Long id) {
		Example e=new Example(Product.class);
		return productMapper.selectByPrimaryKey(id);
	}*/
	
	
}
