package com.inossem.wms.model.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.sys.SysRelRoleResourcesKey", description="角色权限组合键对象")
public class SysRelRoleResourcesKey {
	
	@ApiModelProperty(value="权限编码", name="web_abnormal_workflow",example="1", required=true)
    private String resourcesCode;

	@ApiModelProperty(value="角色编码", name="roleCode",example="1", required=true)
    private String roleCode;


    public String getResourcesCode() {
		return resourcesCode;
	}

	public void setResourcesCode(String resourcesCode) {
		this.resourcesCode = resourcesCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

//	public String getRoleId() {
//        return roleCode;
//    }
//
//    public void setRoleId(String roleId) {
//        this.roleCode = roleId == null ? null : roleId.trim();
//    }
	
	
}