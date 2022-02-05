package com.inossem.wms.model.actor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.model.actor.ActorRelPostRoleKey",description = "岗位与角色相关信息映射类")
public class ActorRelPostRoleKey {
    @ApiModelProperty(name = "postCode",value="岗位编号",required = true,example = "")
    private String postCode;
    @ApiModelProperty(name = "roleCode",value="角色编号",required = true,example = "")
    private String roleCode;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }
}