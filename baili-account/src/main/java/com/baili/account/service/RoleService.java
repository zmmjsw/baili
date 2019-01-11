package com.baili.account.service;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baili.account.entity.vo.RoleConditionVo;
import com.baili.account.mapper.RoleMapper;
import com.baili.core.entity.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
* @ClassName: RoleService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author zhumingming 
* @date 2018年11月23日 上午10:27:37 
*
 */
@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	public void addRole(Role role) {
		roleMapper.insert(role);
	}

	public void deleteRoleById(Long id) {
		roleMapper.deleteRolePermissionByRoleId(id);
		roleMapper.deleteUserRoleByRoleId(id);
		roleMapper.deleteByPrimaryKey(id);
		
	}

	public Role findRoleById( Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	public PageInfo<Role> findRoleList(@Valid RoleConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<Role> Products = roleMapper.findPageBreakByCondition(vo);
		PageInfo<Role> bean = new PageInfo<Role>(Products);
		bean.setList(Products);
		return bean;
	}

}
