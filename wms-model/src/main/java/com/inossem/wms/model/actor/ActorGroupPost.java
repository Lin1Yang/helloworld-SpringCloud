package com.inossem.wms.model.actor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value="com.inossem.wms.model.actor.ActorGroupPost",description = "岗位组与岗位映射")
public class ActorGroupPost extends ActorGroupPostKey {
    @ApiModelProperty(name="required",value="是否必须：0-否，1-是",required = true,example = "0")
    private Byte required;

    @ApiModelProperty(name="postIndex",value="位置排序字段，0,1,2,3,.....",required = true,example = "0")
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

    @ApiModelProperty(name="gpExt0",value="预留字段：gpExt0，gpExt1......gpExt9")
    private String gpExt0;

    @ApiModelProperty(name="gpExt1",value="预留字段",hidden = true)
    private String gpExt1;

    @ApiModelProperty(name="gpExt2",value="预留字段",hidden = true)
    private String gpExt2;

    @ApiModelProperty(name="gpExt3",value="预留字段",hidden = true)
    private String gpExt3;

    @ApiModelProperty(name="gpExt4",value="预留字段",hidden = true)
    private String gpExt4;

    @ApiModelProperty(name="gpExt5",value="预留字段",hidden = true)
    private String gpExt5;

    @ApiModelProperty(name="gpExt6",value="预留字段",hidden = true)
    private String gpExt6;

    @ApiModelProperty(name="gpExt7",value="预留字段",hidden = true)
    private String gpExt7;

    @ApiModelProperty(name="gpExt8",value="预留字段",hidden = true)
    private String gpExt8;

    @ApiModelProperty(name="gpExt9",value="预留字段",hidden = true)
    private String gpExt9;

    public Byte getRequired() {
        return required;
    }

    public void setRequired(Byte required) {
        this.required = required;
    }

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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getGpExt0() {
        return gpExt0;
    }

    public void setGpExt0(String gpExt0) {
        this.gpExt0 = gpExt0 == null ? null : gpExt0.trim();
    }

    public String getGpExt1() {
        return gpExt1;
    }

    public void setGpExt1(String gpExt1) {
        this.gpExt1 = gpExt1 == null ? null : gpExt1.trim();
    }

    public String getGpExt2() {
        return gpExt2;
    }

    public void setGpExt2(String gpExt2) {
        this.gpExt2 = gpExt2 == null ? null : gpExt2.trim();
    }

    public String getGpExt3() {
        return gpExt3;
    }

    public void setGpExt3(String gpExt3) {
        this.gpExt3 = gpExt3 == null ? null : gpExt3.trim();
    }

    public String getGpExt4() {
        return gpExt4;
    }

    public void setGpExt4(String gpExt4) {
        this.gpExt4 = gpExt4 == null ? null : gpExt4.trim();
    }

    public String getGpExt5() {
        return gpExt5;
    }

    public void setGpExt5(String gpExt5) {
        this.gpExt5 = gpExt5 == null ? null : gpExt5.trim();
    }

    public String getGpExt6() {
        return gpExt6;
    }

    public void setGpExt6(String gpExt6) {
        this.gpExt6 = gpExt6 == null ? null : gpExt6.trim();
    }

    public String getGpExt7() {
        return gpExt7;
    }

    public void setGpExt7(String gpExt7) {
        this.gpExt7 = gpExt7 == null ? null : gpExt7.trim();
    }

    public String getGpExt8() {
        return gpExt8;
    }

    public void setGpExt8(String gpExt8) {
        this.gpExt8 = gpExt8 == null ? null : gpExt8.trim();
    }

    public String getGpExt9() {
        return gpExt9;
    }

    public void setGpExt9(String gpExt9) {
        this.gpExt9 = gpExt9 == null ? null : gpExt9.trim();
    }
}