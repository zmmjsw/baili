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

import com.baili.account.entity.vo.PermissionsConditionVo;
import com.baili.account.service.PermissionsService;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.entity.Permissions;
import com.baili.core.util.PageResult;
import com.baili.core.util.ResultUtil;
import com.baili.core.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: PermissionsController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年11月23日 上午10:25:01 
*
 */


@Api(value = "权限controller", tags = { "权限操作接口" })
@RestController
@RequestMapping("/permissions")
public class PermissionsController {
	
	
	@Autowired
	private PermissionsService permissionsService;

	@PostMapping("/add")
	@ApiOperation(value="添加权限信息",notes="权限添加")
	public ResponseVo<Void> addMerchant(@Valid@RequestBody Permissions permissions) {
		permissionsService.addPermissions(permissions);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}

	@PostMapping("/delete")
	@ApiOperation(value="删除权限",notes="权限删除")
	public ResponseVo<Void> deleteMerchant(@NotNull@RequestParam(value = "id") Long id) {
		permissionsService.deletePermissionsById(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}


	@GetMapping("/findOne")
	@ApiOperation(value="权限详情",notes="根据id查询权限")
	public ResponseVo<Permissions> findMerchantById(@NotNull@RequestParam(value = "id") Long id) {
		return new ResponseVo<Permissions>(ResponseStatusEnum.SUCCESS,permissionsService.findPermissionsById(id));
	}

	@PostMapping("/findList")
	@ApiOperation(value="权限列表",notes="根据条件查询权限列表")
	public PageResult<Permissions> findAllMerchant(@Valid@RequestBody PermissionsConditionVo vo) {
		PageInfo<Permissions> permissions = permissionsService.findPermissionsList(vo);
		return  ResultUtil.tablePage(permissions,ResponseStatusEnum.SUCCESS);
	}


}
