package com.baili.util.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baili.dao.mysql.menu.entity.BlMenu;
import com.baili.util.easyui.UiTree;

public class BlMenuUitl {
	
	 public  static Comparator<BlMenu> order(){
		   Comparator<BlMenu> comparator = new Comparator<BlMenu>() {
		     @Override
		     public int compare(BlMenu o1, BlMenu o2) {
		       if(o1.getSort() != o2.getSort()){
		         return o1.getSort() - o2.getSort();
		       }
		       return 0;
		     }
		   };
		   return comparator;
		 }
	 
	 
	 /**
	 * @Title: ListMenujson 
	 * @Description: TODO(获取菜单json集合) 
	 * @param @param allMenu
	 * @param @return    设定文件 
	 * @return List<BlMenu>    返回类型
	 * @author Yuanquan
	 * @throws
	  */
	 public static  List<BlMenu>  ListMenujson(List<BlMenu> allMenu ){
		//根节点
	      List<BlMenu> rootMenu = new ArrayList<BlMenu>();
	      for (BlMenu nav : allMenu) {
	        if(nav.getParentid().equals("0")){//父节点是0的，为根节点。
	          rootMenu.add(nav);
	        }
	      }
	      /* 根据Menu类的order排序 */
	      Collections.sort(rootMenu, order());
	      //为根菜单设置子菜单，getClild是递归调用的
	      for (BlMenu nav : rootMenu) {
	        /* 获取根节点下的所有子节点 使用getChild方法*/
	        List<BlMenu> childList = getChild(nav.getId(), allMenu);
	        nav.setChildren(childList);//给根节点设置子节点
	      }
	      return rootMenu;
	 }
	 /**
	   * 获取子节点
	   * @param id 父节点id
	   * @param allMenu 所有菜单列表
	   * @return 每个根节点下，所有子菜单列表
	   */
	  public static List<BlMenu> getChild(String id,List<BlMenu> allMenu){
		    //子菜单
		    List<BlMenu> childList = new ArrayList<BlMenu>();
		    for (BlMenu nav : allMenu) {
		      // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
		      //相等说明：为该根节点的子节点。
		      if(nav.getParentid().equals(id)){
		        childList.add(nav);
		      }
		    }
		    //递归
		    for (BlMenu nav : childList) {
		      nav.setChildren(getChild(nav.getId(), allMenu));
		    }
		    Collections.sort(childList,order());//排序
		    //如果节点下没有子节点，返回一个空List（递归退出）
		    if(childList.size() == 0){
		      return new ArrayList<BlMenu>();
		    }
		    return childList;
	  }

	  /**
	  * @Title: ListMenuEasyjs 
	  * @Description: TODO(获取菜单eszyjs集合) 
	  * @param @param allMenu
	  * @param @return    设定文件 
	  * @return List<BlMenu>  返回类型
	  * @author Yuanquan
	  * @throws
	   */
	  public static  List<BlMenu>  ListMenuEasyjs(List<BlMenu> allMenu ){
			//根节点
		      List<BlMenu> rootMenu = new ArrayList<BlMenu>();
		      for (BlMenu nav : allMenu) {
		        if(nav.getParentid().equals("0")){//父节点是0的，为根节点。
		          rootMenu.add(nav);
		        }
		      }
		      /* 根据Menu类的order排序 */
		      Collections.sort(rootMenu, order());
		      //为根菜单设置子菜单，getClild是递归调用的
		      for (BlMenu nav : rootMenu) {
		        /* 获取根节点下的所有子节点 使用getChild方法*/
		        List<BlMenu> childList = getChild(nav.getId(), allMenu);
		        nav.setChildren(childList);//给根节点设置子节点
		      }
		      return rootMenu;
		 }
	  
	  /**
	  * @Title: getMenuTreeNode 
	  * @Description: TODO(这里用一句话描述这个方法的作用) 
	  * @param @param menu
	  * @param @param allMenuList
	  * @param @return    设定文件 
	  * @return UiTree    返回类型
	  * @author Yuanquan
	  * @throws
	   */
	  public static UiTree getMenuTreeNode(BlMenu menu, List<BlMenu> allMenuList) {
			UiTree tree = new UiTree();
			tree.setId(menu.getId());
			tree.setText(menu.getLinkname());
			
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("menuId", menu.getId());
			attributes.put("src", menu.getFilename()+"/"+menu.getPageurl());
			attributes.put("type", menu.getType());
			attributes.put("seq", menu.getSort());
			tree.setAttributes(attributes);
			
			List<BlMenu> subMenuList = new ArrayList<BlMenu>();
			for(BlMenu subMenu : allMenuList){
				if(subMenu.getParentid().equals(menu.getId())){
					subMenuList.add(subMenu);
				}
			}
			if(subMenuList != null && subMenuList.size() > 0){
				//Collections.sort(subMenuList, menu.getSort());// 排序
				  Collections.sort(subMenuList,order());//排序
				List<UiTree> subTreeSet = new ArrayList<UiTree>();
				for (BlMenu subMenu : subMenuList) {
					subTreeSet.add(getMenuTreeNode(subMenu, allMenuList));
				}
				
				if(subTreeSet.size() > 0){
					tree.setState("closed");
					tree.setChildren(subTreeSet);
				}
			}
			return tree;
		}
		
}
