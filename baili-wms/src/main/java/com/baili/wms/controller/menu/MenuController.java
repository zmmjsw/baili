package com.baili.wms.controller.menu;
/**
* @ClassName: MenuController 
* @Description: TODO(菜单控制层) 
* @author 袁泉
* @date 2018年10月25日 下午4:28:51 
 */


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baili.util.CommonResponse;
import com.baili.util.Sys;
import com.baili.wms.service.menu.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *
* @ClassName: BlMenuController 
* @Description: TODO(菜单控制类) 
* @author Yuanquan
* @date 2018年5月14日 下午4:31:06
 */
@Api("菜单")
@RestController
@RequestMapping(value="blmenu")
public class MenuController {

	private static final Logger blog=LoggerFactory.getLogger(MenuController.class); 
	
	@Autowired
	@Qualifier(value="BlMenuServer")
	private MenuService blser;
	
	/**
	* @Title: listBlmenu 
	* @Description: TODO(获取菜单列表) 
	* @param @param type 
	* @param @return    设定文件 
	* @return CommonResponse    返回类型
	* @author Yuanquan
	* @throws
	 */
	@ApiOperation(value="菜单信息",httpMethod="POST",notes="货物菜单信息")
	@RequestMapping(value="/listBlmenu",method=RequestMethod.POST)
	public @ResponseBody CommonResponse listBlmenu(@ApiParam(value="type 数据类型") @RequestParam(required=false) String type){
		CommonResponse cr=new CommonResponse();
		Map<String, Object> params=new HashMap<>();
		try {
			if(Sys.isNotNull(type)){
				params.put("type", type);
			}
			cr=blser.listBlMenu(params);
		} catch (Exception e) {
			blog.error("Exception异常提示:"+e.getMessage());
			cr.setCode(500);
			cr.setDesc("Exception异常提示:"+e.getMessage());
		}
		return cr;
	} 
}
