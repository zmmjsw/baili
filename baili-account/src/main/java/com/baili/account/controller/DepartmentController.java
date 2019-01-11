package com.baili.account.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baili.account.entity.vo.DepartmentConditionVo;
import com.baili.account.service.DepartmentService;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.entity.Department;
import com.baili.core.util.PageResult;
import com.baili.core.util.ResultUtil;
import com.baili.core.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: DepartmentController 
* @Description: TODO(部门controller) 
* @author zhumingming 
* @date 2018年11月23日 上午10:23:26 
*
 */
@Api(value = "部门controller", tags = { "部门操作接口" })
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/add")
	@ApiOperation(value="添加部门信息",notes="部门添加")
	public ResponseVo<Void> addDepartment(@Valid@RequestBody Department department) {
		departmentService.addDepartment(department);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}

	@PostMapping("/delete")
	@ApiOperation(value="删除部门",notes="部门删除")
	public ResponseVo<Void> deleteDepartment(@NotNull@RequestParam(value = "id") Long id) {
		departmentService.deleteDepartmentById(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}


	@GetMapping("/findOne")
	@ApiOperation(value="部门详情",notes="根据id查询部门")
	public ResponseVo<Department> findDepartmentById(@NotNull@RequestParam(value = "id") Long id) {
		return new ResponseVo<Department>(ResponseStatusEnum.SUCCESS,departmentService.findDepartmentById(id));
	}

	@PostMapping("/findList")
	@ApiOperation(value="部门列表",notes="根据条件查询部门列表")
	public PageResult<Department> findAllDepartment(@Valid@RequestBody DepartmentConditionVo vo) {
		PageInfo<Department> permissions = departmentService.findDepartmentList(vo);
		return  ResultUtil.tablePage(permissions,ResponseStatusEnum.SUCCESS);
	}
	
	
	

}
