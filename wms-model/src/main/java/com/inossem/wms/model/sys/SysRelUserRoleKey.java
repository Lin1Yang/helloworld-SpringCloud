package com.inossem.wms.model.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.sys.SysRelUserRoleKey", description="用户角色唯一组合建对象")
public class SysRelUserRoleKey {
	@ApiModelProperty(value="用户ID", name="userId",example="1", required=true)
    private Integer userId;
	
	@ApiModelProperty(value="角色编码", name="roleCode",example="0111", required=true)
    private String roleCode;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

  
    
}