package com.baili.core.util;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import com.baili.core.entity.User;
/**
 * 
* @ClassName: PasswordHelper 
* @Description: TODO(shiro密码加密) 
* @author zhumingming 
* @date 2018年11月23日 下午3:09:35 
*
 */
public class PasswordHelper {
	private  static final String algorithmName = "md5";
	private  static final int hashIterations = 2;

	public void encryptPassword(User user) {
		String newPassword = new SimpleHash(algorithmName, user.getPassWord(),  ByteSource.Util.bytes(user.getName()), hashIterations).toHex();
		user.setPassWord(newPassword);

	}
	
}
