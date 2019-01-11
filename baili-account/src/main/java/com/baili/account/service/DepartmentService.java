package com.baili.account.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baili.account.entity.vo.DepartmentConditionVo;
import com.baili.account.mapper.DepartmentMapper;
import com.baili.core.entity.Department;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
* @ClassName: DepartmentService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年12月7日 下午5:05:25 
*
 */

@Service
@Transactional
public class DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;

		
		

	public void addDepartment(Department department) {
		departmentMapper.insert(department);
	}	


	public void deleteDepartmentById(@NotNull Long id) {
		departmentMapper.deleteByPrimaryKey(id);
	}

	

	public Department findDepartmentById(@NotNull Long id) {
		return departmentMapper.selectByPrimaryKey(id);
	}




	public PageInfo<Department> findDepartmentList(@Valid DepartmentConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<Department> objs = departmentMapper.findPageBreakByCondition(vo);
		PageInfo<Department> bean = new PageInfo<Department>(objs);
		bean.setList(objs);
		return bean;
	}













	
}
