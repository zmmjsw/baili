package com.baili.account.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.baili.account.entity.vo.UserConditionVo;
import com.baili.account.entity.vo.UserMenuVo;
import com.baili.account.mapper.CompanyMapper;
import com.baili.account.mapper.PermissionsMapper;
import com.baili.account.mapper.RoleMapper;
import com.baili.account.mapper.UserMapper;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.common.exception.MyException;
import com.baili.core.entity.Authority;
import com.baili.core.entity.Company;
import com.baili.core.entity.Permissions;
import com.baili.core.entity.Role;
import com.baili.core.entity.User;
import com.baili.core.util.PasswordHelper;
import com.baili.core.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: UserService
 * @Description: TODO(用户service)
 * @author zhumingming
 * @date 2018年11月22日 上午10:29:27
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermissionsMapper permissionsMapper;

	@Autowired
	private CompanyMapper companyMapper;

	@Autowired
	private StringRedisTemplate redisTemplate;

	public User findUserByUserName(String userName) {
		RedisUtil ru = new RedisUtil();
		ru.setRedisTemplate(redisTemplate);
		Boolean hasKey = ru.hasKey(userName);
		if (hasKey) {
			String tt = ru.get(userName);
			User user1 = JSON.parseObject(tt, User.class);
			ru.delete(userName);
			ru.set(userName, tt);
			ru.expire(userName, 1l, TimeUnit.DAYS);// 设置过期时间
			return user1;
		}
		User userInfo = null;
		User user = new User();
		user.setUserName(userName);
		userInfo = userMapper.selectOne(user);
		if (userInfo == null) {
			throw new MyException(ResponseStatusEnum.NOT_FOUND);
		}
		List<Role> Roles = roleMapper.findRoleByUserId(userInfo.getId());
		for (Role r : Roles) {
			List<Permissions> PermissionsList = permissionsMapper.findPermissionsByRoleId(r.getId());
			r.setPermissions(PermissionsList);
		}
		userInfo.setRoles(Roles);
		Long companyId = userInfo.getCompanyId();// 公司Id
		Company company = companyMapper.selectByPrimaryKey(companyId);
		userInfo.setCompany(company);
		String userJson = JSON.toJSONString(userInfo);
		ru.set(userName, userJson);
		ru.expire(userName, 1l, TimeUnit.DAYS);// 设置过期时间
		return userInfo;
	}

	public void addToken(Subject subject) {
		String id = subject.getSession().getId().toString();
		User principal = (User) subject.getPrincipal();
		RedisUtil ru = new RedisUtil();
		ru.setRedisTemplate(redisTemplate);
		ru.set(id, principal.getUserName());
		ru.expire(id, 1000 * 60 * 30l, TimeUnit.SECONDS);// 设置过期时间
	}

	public void removeToken(Subject subject) {
		String id = subject.getSession().getId().toString();
		RedisUtil ru = new RedisUtil();
		ru.setRedisTemplate(redisTemplate);
		ru.delete(id);
	}

	public void addUser(User user) {
		PasswordHelper ph = new PasswordHelper();
		ph.encryptPassword(user);
		userMapper.insert(user);
	}

	public PageInfo<User> findUsers(UserConditionVo vo) {
		PageHelper.startPage(vo.getPageNumber(), vo.getPageSize());
		List<User> Products = userMapper.findPageBreakByCondition(vo);
		PageInfo<User> bean = new PageInfo<User>(Products);
		bean.setList(Products);
		return bean;
	}

	public void deleteUserById(Long id) {
		userMapper.deleteUserRoleByUserId(id);
		userMapper.deleteByPrimaryKey(id);

	}

	public UserMenuVo getUserMenu() {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		List<Role> roles = user.getRoles();
		List<Authority> usauthoritys = new ArrayList<Authority>();// 角色中所有的操作权限
		UserMenuVo vo=new UserMenuVo();
		vo.setName(user.getName());// 用户姓名
		roles.stream().forEach(c->{usauthoritys.addAll(c.getAuthoritys());});
		List<Permissions> usPermissions = new ArrayList<Permissions>();
		roles.stream().forEach(c->{c.getPermissions().stream().forEach(a->{
				List<Authority> existsList = getExistsList(a.getAuthoritys(),usauthoritys);
				Permissions usp = new Permissions();
				usp.setName(a.getName());
				usp.setUrl(a.getUrl());
				usp.setSeq(a.getSeq());
				usp.setAuthoritys(existsList);
				usPermissions.add(usp);
			});
		});
/*		for (Role r : roles) {
			List<Permissions> permissions = r.getPermissions();
			for (Permissions p : permissions) {
				List<Authority> pAuthoritys = p.getAuthoritys();
				List<Authority> existsList = getExistsList(pAuthoritys,usauthoritys);
				Permissions usp = new Permissions();
				usp.setName(p.getName());
				usp.setUrl(p.getUrl());
				usp.setSeq(p.getSeq());
				usp.setAuthoritys(existsList);
				usPermissions.add(usp);
			}
		}*/
		vo.setPermissionss(usPermissions);
		return vo;
	}

	//取两个集合的相同元素
	private List<Authority> getExistsList(List<Authority> first, List<Authority> second) {
		// 1.申明map集合
		Map<Authority, Integer> map = new HashMap<Authority, Integer>();
		// 2.把第一个集合的值复制给map的key,并且设置值为1
		for (Authority s : first) {
			map.put(s, 1);
		}
		// 3.把第二个集合的值作为map集合的key拿来判断有没有值
		for (Authority ss : second) {
			Integer ii = map.get(ss);
			if (ii != null) {
				map.put(ss, ++ii);
				continue;
			}
			map.put(ss, 11);
		}
		// 把map集合复制给list集合
		List<Authority> li3 = new ArrayList<Authority>();
		for (Map.Entry<Authority, Integer> mm : map.entrySet()) {
			if (mm.getValue() == 2) {
				li3.add(mm.getKey());
			}
		}
		return li3;
	}

}
