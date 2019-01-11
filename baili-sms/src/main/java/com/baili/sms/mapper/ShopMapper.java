package com.baili.sms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baili.sms.common.plugin.BaseMapper;
import com.baili.sms.entity.Shop;
import com.baili.sms.entity.vo.ShopConditionVo;


/**
 * 
 * @ClassName: AttributeValueMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年12月6日 下午3:30:08
 *
 */

@Mapper
public interface ShopMapper extends BaseMapper<Shop> {
	/**
	 * 
	 * @Title: findPageBreakByCondition
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return List<AttributeKey> 返回类型
	 */
	List<Shop> findPageBreakByCondition(@Param("vo") ShopConditionVo vo);

}
