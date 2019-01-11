package com.baili.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baili.core.common.annotation.CompanyAnnotation;
import com.baili.core.common.emus.CompanyCode;
import com.baili.pms.common.plugin.BaseMapper;
import com.baili.pms.entity.ProductSpecs;
import com.baili.pms.entity.vo.ProductSpecsConditionVo;


/**
 * 
* @ClassName: ProductSpecsMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年12月3日 下午2:54:15 
*
 */

@Mapper
public interface ProductSpecsMapper extends BaseMapper<ProductSpecs>{
	/**
	 * 
	* @Title: findPageBreakByCondition 
	* @Description: TODO(根据条件分页查询) 
	* @return List<Product>    返回类型
	 */
	@CompanyAnnotation(Alias=CompanyCode.COMPANY)
	List<ProductSpecs> findPageBreakByCondition(@Param("vo")ProductSpecsConditionVo vo);

}
