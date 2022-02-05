package com.inossem.wms.vo.auth;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.FixedTreeMenu", description="菜单树形对象-固定key值")
public class FixedTreeMenu {
	
	private String parentCode;
	private String resourcesCode;
	@ApiModelProperty(value = "路径",example="/my_documents")
	private String path;
	
	@ApiModelProperty(value = "路径名称",example="my_documents")
	private String name;
	
	@ApiModelProperty(value = "子菜单集合")
	private List<FixedTreeMenu> children;
	
	@ApiModelProperty(value = "跳转到vue路径",example="my_documents/my_approval/list.vue")
	private String component;
	
	@ApiModelProperty(value = "菜单名称及图标对象")
	private FixedTreeMenuMeta meta;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FixedTreeMenu> getChildren() {
		return children;
	}

	public void setChildren(List<FixedTreeMenu> children) {
		this.children = children;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public FixedTreeMenuMeta getMeta() {
		return meta;
	}

	public void setMeta(FixedTreeMenuMeta meta) {
		this.meta = meta;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getResourcesCode() {
		return resourcesCode;
	}

	public void setResourcesCode(String resourcesCode) {
		this.resourcesCode = resourcesCode;
	}


}