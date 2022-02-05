package com.inossem.wms.model.sys;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.sys.SysRelUserRole", description="用户角色信息对象")
public class SysRelUserRole extends SysRelUserRoleKey {
	
    @ApiModelProperty(value="用户角色创建时间", name="createTime",example="2018-12-24 12:12:12", required=true)
    private Date createTime;
    
    @ApiModelProperty(value="用户角色修改时间", name="modifyTime",example="2018-12-24 12:12:12", required=true)
    private Date modifyTime;
    
    @ApiModelProperty(value="创建用户角色的用户的用户ID", name="createUserId",example="1", required=true)
    private Integer createUserId;
    
    @ApiModelProperty(value="修改用户角色的用户的用户ID", name="modifyUserId",example="1", required=true)
    private Integer modifyUserId;

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
}