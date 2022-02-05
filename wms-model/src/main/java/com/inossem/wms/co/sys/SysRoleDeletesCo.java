package com.inossem.wms.co.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysRoleDeletesCo", description="角色删除对象")
public class SysRoleDeletesCo {
	
	@ApiModelProperty(value="角色编码", name="roleCode",example="0001", required=true)
    private String roleCode;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	
}
