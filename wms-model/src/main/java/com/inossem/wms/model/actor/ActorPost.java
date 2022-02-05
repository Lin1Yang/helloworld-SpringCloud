package com.inossem.wms.model.actor;

import com.inossem.wms.page.PageCommon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author Gyl
 */
@ApiModel(value = "com.inossem.wms.model.actor.ActorPost",description = "经办人岗位管理映射类")
public class ActorPost extends PageCommon {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4072092530411254191L;

	@ApiModelProperty(name = "postCode",value ="岗位编号",required = true,example="")
    private String postCode;

    @ApiModelProperty(name = "corpCode",value ="公司编号",required = true,example="")
    private String corpCode;

    @ApiModelProperty(name = "postName",value ="岗位名称",required = true,example="")
    private String postName;

    @ApiModelProperty(name = "countersign",value ="是否会签，0-否，1-是",required = true,example="")
    private Byte countersign;

    @ApiModelProperty(name = "isDelete",value ="是否删除",required = true,example="",hidden = true)
    private Byte isDelete;

    @ApiModelProperty(name = "createTime",value ="创建时间",required = true,example="",hidden = true)
    private Date createTime;

    @ApiModelProperty(name = "modifyTime",value ="修改时间",required = true,example="",hidden = true)
    private Date modifyTime;

    @ApiModelProperty(name = "modifyUserId",value ="修改用户ID",required = true,example="",hidden = true)
    private Integer modifyUserId;

    @ApiModelProperty(name = "createUserId",value ="创建用户ID",required = true,example="",hidden = true)
    private Integer createUserId;

    @ApiModelProperty(name = "postExt0",value ="预留字段，postExt0，postExt1......postExt9",example="")
    private String postExt0;

    @ApiModelProperty(name = "postExt1",value ="预留字段",example="",hidden = true)
    private String postExt1;

    @ApiModelProperty(name = "postExt2",value ="预留字段",example="",hidden = true)
    private String postExt2;

    @ApiModelProperty(name = "postExt3",value ="预留字段",example="",hidden = true)
    private String postExt3;

    @ApiModelProperty(name = "postExt4",value ="预留字段",example="",hidden = true)
    private String postExt4;

    @ApiModelProperty(name = "postExt5",value ="预留字段",example="",hidden = true)
    private String postExt5;

    @ApiModelProperty(name = "postExt6",value ="预留字段",example="",hidden = true)
    private String postExt6;

    @ApiModelProperty(name = "postExt7",value ="预留字段",example="",hidden = true)
    private String postExt7;

    @ApiModelProperty(name = "postExt8",value ="预留字段",example="",hidden = true)
    private String postExt8;

    @ApiModelProperty(name = "postExt9",value ="预留字段",example="",hidden = true)
    private String postExt9;

    @ApiModelProperty(name = "check",value ="安卓使用字段",example="",hidden = true)
    private boolean check = false;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public Byte getCountersign() {
        return countersign;
    }

    public void setCountersign(Byte countersign) {
        this.countersign = countersign;
    }

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

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getPostExt0() {
        return postExt0;
    }

    public void setPostExt0(String postExt0) {
        this.postExt0 = postExt0 == null ? null : postExt0.trim();
    }

    public String getPostExt1() {
        return postExt1;
    }

    public void setPostExt1(String postExt1) {
        this.postExt1 = postExt1 == null ? null : postExt1.trim();
    }

    public String getPostExt2() {
        return postExt2;
    }

    public void setPostExt2(String postExt2) {
        this.postExt2 = postExt2 == null ? null : postExt2.trim();
    }

    public String getPostExt3() {
        return postExt3;
    }

    public void setPostExt3(String postExt3) {
        this.postExt3 = postExt3 == null ? null : postExt3.trim();
    }

    public String getPostExt4() {
        return postExt4;
    }

    public void setPostExt4(String postExt4) {
        this.postExt4 = postExt4 == null ? null : postExt4.trim();
    }

    public String getPostExt5() {
        return postExt5;
    }

    public void setPostExt5(String postExt5) {
        this.postExt5 = postExt5 == null ? null : postExt5.trim();
    }

    public String getPostExt6() {
        return postExt6;
    }

    public void setPostExt6(String postExt6) {
        this.postExt6 = postExt6 == null ? null : postExt6.trim();
    }

    public String getPostExt7() {
        return postExt7;
    }

    public void setPostExt7(String postExt7) {
        this.postExt7 = postExt7 == null ? null : postExt7.trim();
    }

    public String getPostExt8() {
        return postExt8;
    }

    public void setPostExt8(String postExt8) {
        this.postExt8 = postExt8 == null ? null : postExt8.trim();
    }

    public String getPostExt9() {
        return postExt9;
    }

    public void setPostExt9(String postExt9) {
        this.postExt9 = postExt9 == null ? null : postExt9.trim();
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}