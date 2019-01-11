package com.baili.account.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baili.account.common.plugin.BaseMapper;
import com.baili.account.entity.vo.UserConditionVo;
import com.baili.core.entity.User;

/**
 * 
* @ClassName: MerchantMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年6月4日 下午3:02:05 
*
 */

@Mapper
public interface UserMapper extends BaseMapper<User>{

	List<User> findPageBreakByCondition(@Param("vo")UserConditionVo vo);

	void deleteUserRoleByUserId(Long id);

}
