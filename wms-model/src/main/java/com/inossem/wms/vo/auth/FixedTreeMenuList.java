package com.inossem.wms.vo.auth;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.FixedTreeMenuList", description="菜单树形对象-外面包的对象")
public class FixedTreeMenuList {
	@ApiModelProperty(value = "菜单集合")
	private List<FixedTreeMenu> menuList;
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	
	@ApiModelProperty(value = "用户名")
	private String userName;
	public List<FixedTreeMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<FixedTreeMenu> menuList) {
		this.menuList = menuList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}