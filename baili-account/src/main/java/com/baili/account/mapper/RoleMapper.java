package com.baili.account.mapper;


import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baili.account.common.plugin.BaseMapper;
import com.baili.account.entity.vo.RoleConditionVo;
import com.baili.core.entity.Role;



/**
 * 
* @ClassName: ProcuctDao 
* @Description: TODO(商品持久类 mybatis) 
* @author zhumingming 
* @date 2018年5月31日 下午1:50:12 
*
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role>{
	
	List<Role> findRoleByUserId(Long id);

	int deleteRolePermissionByRoleId(Long id);

	int deleteUserRoleByRoleId(Long id);

	List<Role> findPageBreakByCondition(@Param("vo")RoleConditionVo vo);

}
