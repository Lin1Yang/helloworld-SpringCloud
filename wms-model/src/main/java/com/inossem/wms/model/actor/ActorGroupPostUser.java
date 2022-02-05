package com.inossem.wms.model.actor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value="com.inossem.wms.model.actor.ActorGroupPostUser",description = "岗位组，岗位，人员映射")
public class ActorGroupPostUser extends ActorGroupPostUserKey {
    @ApiModelProperty(name="postIndex",value="岗位排序",required = true)
    private Integer postIndex;

    @ApiModelProperty(name="isDelete",value="删除标识",required = true,hidden = true)
    private Byte isDelete;

    @ApiModelProperty(name="createUserId",value="创建人ID",required = true,hidden = true)
    private Integer createUserId;

    @ApiModelProperty(name="modifyUserId",value="修改人ID",required = true,hidden = true)
    private Integer modifyUserId;

    @ApiModelProperty(name="createTime",value="创建时间",required = true,hidden = true)
    private Date createTime;

    @ApiModelProperty(name="modifyTime",value="修改时间",required = true,hidden = true)
    private Date modifyTime;

    @ApiModelProperty(name="gpuExt0",value="预留字段：gpuExt0，gpuExt1......gpuExt9")
    private String gpuExt0;

    @ApiModelProperty(name="gpuExt1",value="预留字段",hidden = true)
    private String gpuExt1;

    @ApiModelProperty(name="gpuExt2",value="预留字段",hidden = true)
    private String gpuExt2;

    @ApiModelProperty(name="gpuExt3",value="预留字段",hidden = true)
    private String gpuExt3;

    @ApiModelProperty(name="gpuExt4",value="预留字段",hidden = true)
    private String gpuExt4;

    @ApiModelProperty(name="gpuExt5",value="预留字段",hidden = true)
    private String gpuExt5;

    @ApiModelProperty(name="gpuExt6",value="预留字段",hidden = true)
    private String gpuExt6;

    @ApiModelProperty(name="gpuExt7",value="预留字段",hidden = true)
    private String gpuExt7;

    @ApiModelProperty(name="gpuExt8",value="预留字段",hidden = true)
    private String gpuExt8;

    @ApiModelProperty(name="gpuExt9",value="预留字段",hidden = true)
    private String gpuExt9;

    public Integer getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(Integer postIndex) {
        this.postIndex = postIndex;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGpuExt0() {
        return gpuExt0;
    }

    public void setGpuExt0(String gpuExt0) {
        this.gpuExt0 = gpuExt0 == null ? null : gpuExt0.trim();
    }

    public String getGpuExt1() {
        return gpuExt1;
    }

    public void setGpuExt1(String gpuExt1) {
        this.gpuExt1 = gpuExt1 == null ? null : gpuExt1.trim();
    }

    public String getGpuExt2() {
        return gpuExt2;
    }

    public void setGpuExt2(String gpuExt2) {
        this.gpuExt2 = gpuExt2 == null ? null : gpuExt2.trim();
    }

    public String getGpuExt3() {
        return gpuExt3;
    }

    public void setGpuExt3(String gpuExt3) {
        this.gpuExt3 = gpuExt3 == null ? null : gpuExt3.trim();
    }

    public String getGpuExt4() {
        return gpuExt4;
    }

    public void setGpuExt4(String gpuExt4) {
        this.gpuExt4 = gpuExt4 == null ? null : gpuExt4.trim();
    }

    public String getGpuExt5() {
        return gpuExt5;
    }

    public void setGpuExt5(String gpuExt5) {
        this.gpuExt5 = gpuExt5 == null ? null : gpuExt5.trim();
    }

    public String getGpuExt6() {
        return gpuExt6;
    }

    public void setGpuExt6(String gpuExt6) {
        this.gpuExt6 = gpuExt6 == null ? null : gpuExt6.trim();
    }

    public String getGpuExt7() {
        return gpuExt7;
    }

    public void setGpuExt7(String gpuExt7) {
        this.gpuExt7 = gpuExt7 == null ? null : gpuExt7.trim();
    }

    public String getGpuExt8() {
        return gpuExt8;
    }

    public void setGpuExt8(String gpuExt8) {
        this.gpuExt8 = gpuExt8 == null ? null : gpuExt8.trim();
    }

    public String getGpuExt9() {
        return gpuExt9;
    }

    public void setGpuExt9(String gpuExt9) {
        this.gpuExt9 = gpuExt9 == null ? null : gpuExt9.trim();
    }
}