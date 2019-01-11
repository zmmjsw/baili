package com.baili.pms.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.baili.core.entity.User;

/**
 * 
 * @ClassName: UserFeign
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhumingming
 * @date 2018年11月22日 上午10:36:02
 *
 */

@FeignClient("baili-account")
public interface UserFeign {

	@RequestMapping(value = "/account/user/findUser", method = RequestMethod.POST)
	public User findUserByUserName(@RequestParam(value = "userName") String userName);

}
