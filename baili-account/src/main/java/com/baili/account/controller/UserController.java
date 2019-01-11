package com.baili.account.controller;

import javax.validation.Valid;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baili.account.entity.vo.UserConditionVo;
import com.baili.account.entity.vo.UserMenuVo;
import com.baili.account.service.UserService;
import com.baili.core.common.emus.ResponseStatusEnum;
import com.baili.core.entity.User;
import com.baili.core.util.PageResult;
import com.baili.core.util.ResultUtil;
import com.baili.core.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: UserController
 * @Description: TODO(用户)
 * @author zhumingming
 * @date 2018年11月23日 下午3:05:35
 *
 */
@Api(value = "用户controller", tags = { "用户操作接口" })
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @Title: login
	 * @Description: TODO(登录)
	 * @return ResponseVo 返回类型
	 */
	@ApiOperation(value = "登录的接口", notes = "登录的接口")
	@PostMapping(value = "/login")
	public ResponseVo<Void> login(@NonNull @RequestParam(value = "userName") String userName, @NonNull @RequestParam(value = "passWord") String passWord) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
		subject.login(token);
		userService.addToken(subject);
		return new ResponseVo<Void>(ResponseStatusEnum.LOGIN_SUCCESS);
	}

	/**
	 * 
	 * @Title: logOut
	 * @Description: TODO(登出)
	 * @return String 返回类型
	 */
	@ApiOperation(value = "登出的接口", notes = "登出的接口")
	@PostMapping("/logOut")
	public ResponseVo<Void> logOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		userService.removeToken(subject);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}

	@PostMapping("/findList")
	@ApiOperation(value = "用户列表", notes = "带了权限")
	@RequiresPermissions("userInfo:user") // 权限管理;
	public PageResult<User> findAllProducts(@Valid @RequestBody UserConditionVo vo) {
		PageInfo<User> Products = userService.findUsers(vo);
		return ResultUtil.tablePage(Products, ResponseStatusEnum.SUCCESS);
	}

	@PostMapping("/findUser")
	@ApiOperation(value = "feign用的接口", notes = "根据用户名查找用户")
	public User findUserByUserName(@RequestParam(value = "userName") String userName) {
		User user = userService.findUserByUserName(userName);
		return user;
	};

	@PostMapping("/register")
	@ApiOperation(value = "注册", notes = "注册")
	public ResponseVo<Void> register(@Valid @RequestBody User user) {
		userService.addUser(user);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除用户", notes = "删除用户")
	public ResponseVo<Void> delete(@NonNull @RequestParam(value = "id") Long id) {
		userService.deleteUserById(id);
		return new ResponseVo<Void>(ResponseStatusEnum.SUCCESS);
	}

	@PostMapping("/menu")
	@ApiOperation(value = "获取权限菜单", notes = "获取权限菜单")
	public ResponseVo<UserMenuVo> getUserMenu() {
		return new ResponseVo<UserMenuVo>(ResponseStatusEnum.SUCCESS, userService.getUserMenu());
	}

}
