package com.baili.dao.mysql.menu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.baili.dao.mysql.menu.entity.BlMenu;

/**
* @ClassName: BlMenuMapper 
* @Description: TODO(菜单管理) 
* @author Yuanquan
* @date 2018年5月14日 下午4:09:28
 */

@Repository
public interface BlMenuMapper {

	/**
	* @Title: listBaiLiMenu 
	* @Description: TODO(获取菜单栏信息) 
	* @param @param params
	* @param @throws Exception    设定文件 
	* @return List<BlMenu>    返回类型
	* @author Yuanquan
	* @throws
	 */
	List<BlMenu> listBaiLiMenu(Map<String,Object> params) throws Exception;
	 
}
