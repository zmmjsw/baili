package com.baili.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baili.pms.common.plugin.BaseMapper;
import com.baili.pms.entity.Product;
import com.baili.pms.entity.vo.ProductConditionVo;


/**
 * 
* @ClassName: ProcuctDao 
* @Description: TODO(商品持久类 mybatis) 
* @author zhumingming 
* @date 2018年5月31日 下午1:50:12 
*
 */

@Mapper
public interface ProductMapper extends BaseMapper<Product>{
	/**
	 * 
	* @Title: findPageBreakByCondition 
	* @Description: TODO(根据条件分页查询) 
	* @return List<Product>    返回类型
	 */
	List<Product> findPageBreakByCondition(@Param("vo")ProductConditionVo vo);

}
