package com.inossem.wms.vo.sys;

import java.util.List;

import com.inossem.wms.vo.auth.SysResourcesRoleVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.sys.SysRoleInfoVo", description="角色与用户和权限信息拓展对象")
public class SysRoleInfoVo extends SysRoleVo{
	
	@ApiModelProperty(value="角色已经配置的功能集合", name="roleHaveResources", required=true)
	private	List<SysResourcesRoleVo> roleHaveResources;	
	
	@ApiModelProperty(value="角色还没有配置的功能集合", name="roleNotHaveResources", required=true)
	private	List<SysResourcesRoleVo> roleNotHaveResources;
	
	@ApiModelProperty(value="角色已经配置的用户集合", name="roleHaveUsers", required=true)
	private	List<SysUserVo> roleHaveUsers;
	
	@ApiModelProperty(value="角色还没有配置的用户集合", name="roleNotHaveUsers", required=true)
	private	List<SysUserVo> roleNotHaveUsers;

	public List<SysResourcesRoleVo> getRoleHaveResources() {
		return roleHaveResources;
	}

	public void setRoleHaveResources(List<SysResourcesRoleVo> roleHaveResources) {
		this.roleHaveResources = roleHaveResources;
	}

	public List<SysResourcesRoleVo> getRoleNotHaveResources() {
		return roleNotHaveResources;
	}

	public void setRoleNotHaveResources(List<SysResourcesRoleVo> roleNotHaveResources) {
		this.roleNotHaveResources = roleNotHaveResources;
	}

	public List<SysUserVo> getRoleHaveUsers() {
		return roleHaveUsers;
	}

	public void setRoleHaveUsers(List<SysUserVo> roleHaveUsers) {
		this.roleHaveUsers = roleHaveUsers;
	}

	public List<SysUserVo> getRoleNotHaveUsers() {
		return roleNotHaveUsers;
	}

	public void setRoleNotHaveUsers(List<SysUserVo> roleNotHaveUsers) {
		this.roleNotHaveUsers = roleNotHaveUsers;
	}
	
	
	

}
