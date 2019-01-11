package com.baili.account.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baili.account.common.plugin.BaseMapper;
import com.baili.account.entity.vo.DepartmentConditionVo;
import com.baili.core.entity.Department;

/**
 * 
* @ClassName: DepartmentMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年12月7日 下午5:00:45 
*
 */

@Mapper
public interface DepartmentMapper extends BaseMapper<Department>{

	List<Department> findPageBreakByCondition(@Param("vo")DepartmentConditionVo vo);


}
