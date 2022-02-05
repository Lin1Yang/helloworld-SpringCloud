package com.inossem.wms.co.sys;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysRoleDeleteCo", description="角色删除对象")
public class SysRoleDeleteCo {
	
	@ApiModelProperty(value="角色删除对象集合", name="sysRoleDeletesCos", required=true)
    private List<SysRoleDeletesCo> sysRoleDeletesCos;

	public List<SysRoleDeletesCo> getSysRoleDeletesCos() {
		return sysRoleDeletesCos;
	}

	public void setSysRoleDeletesCos(List<SysRoleDeletesCo> sysRoleDeletesCos) {
		this.sysRoleDeletesCos = sysRoleDeletesCos;
	}
	
	
	
	

}
