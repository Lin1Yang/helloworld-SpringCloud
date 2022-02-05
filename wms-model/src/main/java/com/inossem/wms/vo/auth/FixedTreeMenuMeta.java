package com.inossem.wms.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.FixedTreeMenuMeta", description="菜单树形对象-meta")
public class FixedTreeMenuMeta {
	
	@ApiModelProperty(value = "图标")
	private String icon;
	@ApiModelProperty(value = "菜单名称")
	private String title;
	
	@ApiModelProperty(value = "不缓存")
	private boolean notCache = true;
	
	@ApiModelProperty(value = "外部是否可以映射到到此菜单")
	private boolean hideInMenu = false;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isNotCache() {
		return notCache;
	}

	public void setNotCache(boolean notCache) {
		this.notCache = notCache;
	}

	public boolean isHideInMenu() {
		return hideInMenu;
	}

	public void setHideInMenu(boolean hideInMenu) {
		this.hideInMenu = hideInMenu;
	}

}