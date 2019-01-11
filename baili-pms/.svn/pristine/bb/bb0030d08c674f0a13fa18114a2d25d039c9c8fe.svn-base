package com.baili.pms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baili.pms.common.plugin.BaseMapper;
import com.baili.pms.entity.AttributeKey;
import com.baili.pms.entity.vo.AttributeKeyConditionVo;

/**
 * 
 * @ClassName: AttributeValueMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年12月6日 下午3:30:08
 *
 */

@Mapper
public interface AttributeKeyMapper extends BaseMapper<AttributeKey> {
	/**
	 * 
	 * @Title: findPageBreakByCondition
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return List<AttributeKey> 返回类型
	 */
	List<AttributeKey> findPageBreakByCondition(@Param("vo") AttributeKeyConditionVo vo);

}
