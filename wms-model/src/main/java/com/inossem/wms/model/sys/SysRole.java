package com.inossem.wms.model.sys;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="java.util.Date.SysRole", description="角色对象")
public class SysRole {
	
	@ApiModelProperty(value="角色编码", name="roleCode",example="0001", required=true)
    private String roleCode;
	
	@ApiModelProperty(value="角色名称", name="roleName",example="admin", required=true)
    private String roleName;
	
	@ApiModelProperty(value="角色创建时间", name="createTime",example="2018-24-23 12:12:12", required=true)
    private Date createTime;
	
	@ApiModelProperty(value="角色修改时间", name="modifyTime",example="2018-24-23 12:12:12", required=true)
    private Date modifyTime;
	
	@ApiModelProperty(value="角色创建人ID", name="createUserId",example="1", required=true)
    private Integer createUserId;
	
	@ApiModelProperty(value="角色修改人ID", name="modifyUserId",example="1", required=true)
    private Integer modifyUserId;

    private String roleExt0;

    private String roleExt1;

    private String roleExt2;

    private String roleExt3;

    private String roleExt4;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleId) {
        this.roleCode = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getRoleExt0() {
        return roleExt0;
    }

    public void setRoleExt0(String roleExt0) {
        this.roleExt0 = roleExt0 == null ? null : roleExt0.trim();
    }

    public String getRoleExt1() {
        return roleExt1;
    }

    public void setRoleExt1(String roleExt1) {
        this.roleExt1 = roleExt1 == null ? null : roleExt1.trim();
    }

    public String getRoleExt2() {
        return roleExt2;
    }

    public void setRoleExt2(String roleExt2) {
        this.roleExt2 = roleExt2 == null ? null : roleExt2.trim();
    }

    public String getRoleExt3() {
        return roleExt3;
    }

    public void setRoleExt3(String roleExt3) {
        this.roleExt3 = roleExt3 == null ? null : roleExt3.trim();
    }

    public String getRoleExt4() {
        return roleExt4;
    }

    public void setRoleExt4(String roleExt4) {
        this.roleExt4 = roleExt4 == null ? null : roleExt4.trim();
    }
}