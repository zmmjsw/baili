package com.baili.util.easyui;
import java.util.List;
import java.util.Map;
/**
* @ClassName: UiTree 
* @Description: TODO(EASYUI 菜单树状结构) 
* @author Yuanquan
* @date 2018年5月8日 下午2:52:04
 */
public class UiTree {

	private String id;
	private String text;//节点名称
	private String iconCls;//图标
	private Boolean checked = false;// 是否勾选状态
	private Map<String, Object> attributes;// 属性
	private List<UiTree> children;// 子节点
	private String state = "open";// 是否开启关闭(open,closed)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public List<UiTree> getChildren() {
		return children;
	}
	public void setChildren(List<UiTree> children) {
		this.children = children;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
