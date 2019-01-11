package com.baili.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baili.pms.common.plugin.BaseMapper;
import com.baili.pms.entity.AttributeValue;
import com.baili.pms.entity.vo.AttributeValueConditionVo;


/**
 * 
* @ClassName: AttributeValueMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年12月6日 下午3:30:08 
*
 */

@Mapper
public interface AttributeValueMapper extends BaseMapper<AttributeValue>{
	/**
	 * 
	* @Title: findPageBreakByCondition 
	* @Description: TODO(根据条件分页查询) 
	* @return List<Product>    返回类型
	 */
	List<AttributeValue> findPageBreakByCondition(@Param("vo")AttributeValueConditionVo vo);

}
