package com.inossem.wms.co.sys;

import java.util.List;

import com.inossem.wms.model.sys.SysRole;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.sys.SysRoleInfoCo", description="角色保存和修改对象")
public class SysRoleInfoCo extends SysRole{
	
	@ApiModelProperty(value="是否添加 true-添加 false-修改", name="isAdd",example="false", required=true)
	private Boolean isAdd;
	
	@ApiModelProperty(value="角色与用户", name="sysRelUserRoleInfoCos", required=true)
	private	List<SysRelUserRoleInfoCo> roleHaveUsers; 
	
	@ApiModelProperty(value="角色与权限", name="sysRelUserRoleInfoCos", required=true)
	private	List<SysRelRoleResourcesInfoCo> roleHaveResources;

	

	public List<SysRelUserRoleInfoCo> getRoleHaveUsers() {
		return roleHaveUsers;
	}

	public void setRoleHaveUsers(List<SysRelUserRoleInfoCo> roleHaveUsers) {
		this.roleHaveUsers = roleHaveUsers;
	}

	public List<SysRelRoleResourcesInfoCo> getRoleHaveResources() {
		return roleHaveResources;
	}

	public void setRoleHaveResources(List<SysRelRoleResourcesInfoCo> roleHaveResources) {
		this.roleHaveResources = roleHaveResources;
	}

	public Boolean getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(Boolean isAdd) {
		this.isAdd = isAdd;
	}
	
	
	 

}
