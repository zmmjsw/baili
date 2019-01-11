package com.baili.wms.service.menu;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* @ClassName: MenuService 
* @Description: TODO(菜单管理) 
* @author 袁泉
* @date 2018年10月25日 下午4:02:33 
 */

import com.baili.dao.mysql.menu.dao.BlMenuMapper;
import com.baili.dao.mysql.menu.entity.BlMenu;
import com.baili.util.CommonResponse;
import com.baili.util.menu.BlMenuUitl;

@Service("BlMenuServer")
@Transactional
public class MenuService {

	@Autowired
	private BlMenuMapper  menudao;
	
	public CommonResponse listBlMenu(Map<String, Object> params) throws Exception {
		CommonResponse cr=new CommonResponse();
		List<BlMenu> blmenulist=menudao.listBaiLiMenu(params);
		if(blmenulist.size()>0){
			cr.setCode(200);
			cr.setDesc("查询成功");
			cr.setObj(BlMenuUitl.ListMenujson(blmenulist));//获取菜单json集合
		}else{
			cr.setCode(102);
			cr.setDesc("查无数据");
		}
		return cr;
	}
	
}
