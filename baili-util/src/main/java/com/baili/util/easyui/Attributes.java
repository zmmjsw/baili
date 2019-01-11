package com.baili.util.easyui;
/**
* @ClassName: Attributes 
* @Description: TODO(菜单一级说明) 
* @author Yuanquan
* @date 2018年5月8日 下午2:50:57
 */
public class Attributes {
	
	private String menuId;//菜单编号id
    private Integer seq;//菜单排序
    private String src;//访问地址
    private String type;//类型
    private String pageurl;
    
	public String getPageurl() {
		return pageurl;
	}
	public void setPageurl(String pageurl) {
		this.pageurl = pageurl;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
}
