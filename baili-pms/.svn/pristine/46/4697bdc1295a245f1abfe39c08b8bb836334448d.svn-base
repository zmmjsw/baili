package com.baili.pms.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baili.pms.entity.ProductSpecs;
import com.baili.pms.entity.vo.ProductSpecsConditionVo;
import com.baili.pms.mapper.ProductSpecsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
* @ClassName: ProductSpecsService 
* @Description: TODO(商品规格sku) 
* @author zhumingming 
* @date 2018年12月3日 下午2:51:54 
*
 */

@Service
@Transactional
public class ProductSpecsService {
	
	@Autowired
	private ProductSpecsMapper productSpecsMapper;

	public void addProductSpecs( ProductSpecs productSpecs) {
		productSpecsMapper.insert(productSpecs);
	}

	public void deleteProductSpecs(Long id) {
		productSpecsMapper.deleteByPrimaryKey(id);
		
	}

	public void updateProductSpecs(ProductSpecs productSpecs) {
		productSpecsMapper.updateByPrimaryKeySelective(productSpecs);
		
	}

	public ProductSpecs findProductSpecsById(Long id) {
		return productSpecsMapper.selectByPrimaryKey(id);
	}

	public PageInfo<ProductSpecs> findProductSpecsList(ProductSpecsConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<ProductSpecs> Products = productSpecsMapper.findPageBreakByCondition(vo);
		PageInfo<ProductSpecs> bean = new PageInfo<ProductSpecs>(Products);
		bean.setList(Products);
		return bean;
	}

}
