package com.baili.account.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baili.account.common.plugin.BaseMapper;
import com.baili.account.entity.vo.CompanyConditionVo;
import com.baili.core.entity.Company;

/**
 * 
* @ClassName: CompanyMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年12月6日 下午4:59:14 
*
 */

@Mapper
public interface CompanyMapper extends BaseMapper<Company>{

	List<Company> findPageBreakByCondition(@Param("vo")CompanyConditionVo vo);


}
