package com.inossem.wms.model.actor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "com.inossem.wms.model.actor.ActorRelPostRole",description = "岗位与角色相关信息映射类")
public class ActorRelPostRole extends ActorRelPostRoleKey {
    @ApiModelProperty(name = "isDelete",value="删除标记",required = true,example = "",hidden = true)
    private Byte isDelete;

    @ApiModelProperty(name = "createTime",value="创建时间",required = true,example = "",hidden = true)
    private Date createTime;

    @ApiModelProperty(name = "modifyTime",value="修改时间",required = true,example = "",hidden = true)
    private Date modifyTime;

    @ApiModelProperty(name = "createUserId",value="创建人ID",required = true,example = "",hidden = true)
    private Integer createUserId;

    @ApiModelProperty(name = "modifyUserId",value="修改人ID",required = true,example = "",hidden = true)
    private Integer modifyUserId;

    @ApiModelProperty(name = "rprExt0",value="预留字段：rprExt0，rprExt0......rprExt0")
    private String rprExt0;

    @ApiModelProperty(name = "rprExt1",value="预留字段",example = "",hidden = true)
    private String rprExt1;

    @ApiModelProperty(name = "rprExt2",value="预留字段",example = "",hidden = true)
    private String rprExt2;

    @ApiModelProperty(name = "rprExt3",value="预留字段",example = "",hidden = true)
    private String rprExt3;

    @ApiModelProperty(name = "rprExt4",value="预留字段",example = "",hidden = true)
    private String rprExt4;

    @ApiModelProperty(name = "rprExt5",value="预留字段",example = "",hidden = true)
    private String rprExt5;

    @ApiModelProperty(name = "rprExt6",value="预留字段",example = "",hidden = true)
    private String rprExt6;

    @ApiModelProperty(name = "rprExt7",value="预留字段",example = "",hidden = true)
    private String rprExt7;

    @ApiModelProperty(name = "rprExt8",value="预留字段",example = "",hidden = true)
    private String rprExt8;

    @ApiModelProperty(name = "rprExt9",value="预留字段",example = "",hidden = true)
    private String rprExt9;

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getRprExt0() {
        return rprExt0;
    }

    public void setRprExt0(String rprExt0) {
        this.rprExt0 = rprExt0 == null ? null : rprExt0.trim();
    }

    public String getRprExt1() {
        return rprExt1;
    }

    public void setRprExt1(String rprExt1) {
        this.rprExt1 = rprExt1 == null ? null : rprExt1.trim();
    }

    public String getRprExt2() {
        return rprExt2;
    }

    public void setRprExt2(String rprExt2) {
        this.rprExt2 = rprExt2 == null ? null : rprExt2.trim();
    }

    public String getRprExt3() {
        return rprExt3;
    }

    public void setRprExt3(String rprExt3) {
        this.rprExt3 = rprExt3 == null ? null : rprExt3.trim();
    }

    public String getRprExt4() {
        return rprExt4;
    }

    public void setRprExt4(String rprExt4) {
        this.rprExt4 = rprExt4 == null ? null : rprExt4.trim();
    }

    public String getRprExt5() {
        return rprExt5;
    }

    public void setRprExt5(String rprExt5) {
        this.rprExt5 = rprExt5 == null ? null : rprExt5.trim();
    }

    public String getRprExt6() {
        return rprExt6;
    }

    public void setRprExt6(String rprExt6) {
        this.rprExt6 = rprExt6 == null ? null : rprExt6.trim();
    }

    public String getRprExt7() {
        return rprExt7;
    }

    public void setRprExt7(String rprExt7) {
        this.rprExt7 = rprExt7 == null ? null : rprExt7.trim();
    }

    public String getRprExt8() {
        return rprExt8;
    }

    public void setRprExt8(String rprExt8) {
        this.rprExt8 = rprExt8 == null ? null : rprExt8.trim();
    }

    public String getRprExt9() {
        return rprExt9;
    }

    public void setRprExt9(String rprExt9) {
        this.rprExt9 = rprExt9 == null ? null : rprExt9.trim();
    }
}