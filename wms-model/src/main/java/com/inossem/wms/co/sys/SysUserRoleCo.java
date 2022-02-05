package com.inossem.wms.co.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.sys.SysUserRoleCo", description="用户入参对象")
public class SysUserRoleCo {
	
	@ApiModelProperty(value="用户查询条件-用户编码userCode或用户名称userName", name="condition",example="1", required=true)
	private String condition; //查询条件
		
	@ApiModelProperty(value="角色编码", name="roleCode", example="1", required=true)
    private String roleCode;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	

}
