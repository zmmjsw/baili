package com.baili.account.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baili.account.entity.vo.PermissionsConditionVo;
import com.baili.account.mapper.PermissionsMapper;
import com.baili.core.entity.Permissions;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
* @ClassName: PermissionsService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年11月23日 上午10:27:13 
*
 */
@Service
@Transactional
public class PermissionsService {
	
	@Autowired
	private PermissionsMapper permissionsMapper;

	public void addPermissions(Permissions permissions) {
		permissionsMapper.insert(permissions);
		
	}

	public void deletePermissionsById(Long id) {
		permissionsMapper.deleteRolePermissionsByPermissionsId(id);
		permissionsMapper.deleteByPrimaryKey(id);
		
	}

	public Permissions findPermissionsById(Long id) {
		return permissionsMapper.selectByPrimaryKey(id);
	}

	public PageInfo<Permissions> findPermissionsList(@Valid PermissionsConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<Permissions> Products = permissionsMapper.findPageBreakByCondition(vo);
		PageInfo<Permissions> bean = new PageInfo<Permissions>(Products);
		bean.setList(Products);
		return bean;
	}

}
