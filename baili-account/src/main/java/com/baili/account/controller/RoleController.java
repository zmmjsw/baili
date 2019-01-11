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
import com.baili.account.entity.vo.RoleConditionVo;
import com.baili.account.service.RoleService;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.entity.Role;
import com.baili.core.util.PageResult;
import com.baili.core.util.ResultUtil;
import com.baili.core.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: RoleController 
* @Description: TODO(角色controller) 
* @author zhumingming 
* @date 2018年11月23日 上午10:23:26 
*
 */
@Api(value = "角色controller", tags = { "角色操作接口" })
@RestController
@RequestMapping("/role")
public class RoleController {
	
	

	@Autowired
	private RoleService roleService;

	@PostMapping("/add")
	@ApiOperation(value="添加角色信息",notes="角色添加")
	public ResponseVo<Void> addRole(@Valid@RequestBody Role role) {
		roleService.addRole(role);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}

	@PostMapping("/delete")
	@ApiOperation(value="删除角色",notes="角色删除")
	public ResponseVo<Void> deleteRole(@NotNull@RequestParam(value = "id") Long id) {
		roleService.deleteRoleById(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}


	@GetMapping("/findOne")
	@ApiOperation(value="角色详情",notes="根据id查询角色")
	public ResponseVo<Role> findRoleById(@NotNull@RequestParam(value = "id") Long id) {
		return new ResponseVo<Role>(ResponseStatusEnum.SUCCESS,roleService.findRoleById(id));
	}

	@PostMapping("/findList")
	@ApiOperation(value="角色列表",notes="根据条件查询角色列表")
	public PageResult<Role> findAllRole(@Valid@RequestBody RoleConditionVo vo) {
		PageInfo<Role> permissions = roleService.findRoleList(vo);
		return  ResultUtil.tablePage(permissions,ResponseStatusEnum.SUCCESS);
	}
	
	
	

}
