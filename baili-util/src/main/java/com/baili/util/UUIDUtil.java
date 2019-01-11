package com.baili.util;

import java.util.UUID;
/**
* @ClassName: UUIDUtil 
* @Description: TODO(分布式UUID) 
* @author Yuanquan
* @date 2018年5月9日 下午3:43:32
 */
public class UUIDUtil {

	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
