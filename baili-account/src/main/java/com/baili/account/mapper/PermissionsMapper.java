package com.baili.account.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baili.account.common.plugin.BaseMapper;
import com.baili.account.entity.vo.PermissionsConditionVo;
import com.baili.core.entity.Permissions;


/**
 * 
* @ClassName: StoreProductMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年6月4日 下午3:57:35 
*
 */

@Mapper
public interface PermissionsMapper extends BaseMapper<Permissions>{
	
	List<Permissions> findPermissionsByRoleId(Long id);

	void deleteRolePermissionsByPermissionsId(Long id);

	List<Permissions> findPageBreakByCondition(@Param("vo")PermissionsConditionVo vo);

}
