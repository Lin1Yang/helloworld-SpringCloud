package com.inossem.wms.model.actor;

import java.util.Date;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "com.inossem.wms.model.actor.ActorGroup",description = "经办人岗位组映射类")
public class ActorGroup extends PageCommon {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3932429732161119552L;

	@ApiModelProperty(name = "groupCode",value ="经办人岗位组",required = true,example="")
    private String groupCode;

    @ApiModelProperty(name = "corpCode",value ="公司编码",required = true,example="")
    private String corpCode;

    @ApiModelProperty(name = "receiptType",value ="单据类型",required = true,example="")
    private Integer receiptType;

    @ApiModelProperty(name = "groupName",value ="经办人岗位组名称",required = true,example="")
    private String groupName;

    @ApiModelProperty(name = "createUserName",value ="创建人姓名",required = true,example="")
    private String createUserName;

    @ApiModelProperty(name = "isDefault",value ="是否是默认岗位组",required = true,example="")
    private Byte isDefault;

    @ApiModelProperty(name = "groupType",value ="岗位组类别：0-公司岗位组，1-个人岗自定义位组",required = true,example="")
    private Integer groupType;

    @ApiModelProperty(name = "isDelete",value ="是否删除",required = true,example="",hidden = true)
    private Byte isDelete;

    @ApiModelProperty(name = "createTime",value ="创建时间",required = true,example="",hidden = true)
    private Date createTime;

    @ApiModelProperty(name = "modifyTime",value ="修改时间",required = true,example="",hidden = true)
    private Date modifyTime;

    @ApiModelProperty(name = "createUserId",value ="创建人ID",required = true,example="",hidden = true)
    private Integer createUserId;

    @ApiModelProperty(name = "modifyUserId",value ="修改人ID",required = true,example="",hidden = true)
    private Integer modifyUserId;

    @ApiModelProperty(name = "groupExt0",value ="预留字段,groupExt0,groupExt1......groupExt9",example="")
    private String groupExt0;

    @ApiModelProperty(name = "groupExt1",value ="预留字段",example="",hidden = true)
    private String groupExt1;

    @ApiModelProperty(name = "groupExt2",value ="预留字段",example="",hidden = true)
    private String groupExt2;

    @ApiModelProperty(name = "groupExt3",value ="预留字段",example="",hidden = true)
    private String groupExt3;

    @ApiModelProperty(name = "groupExt4",value ="预留字段",example="",hidden = true)
    private String groupExt4;

    @ApiModelProperty(name = "groupExt5",value ="预留字段",example="",hidden = true)
    private String groupExt5;

    @ApiModelProperty(name = "groupExt6",value ="预留字段",example="",hidden = true)
    private String groupExt6;

    @ApiModelProperty(name = "groupExt7",value ="预留字段",example="",hidden = true)
    private String groupExt7;

    @ApiModelProperty(name = "groupExt8",value ="预留字段",example="",hidden = true)
    private String groupExt8;

    @ApiModelProperty(name = "groupExt9",value ="预留字段",example="",hidden = true)
    private String groupExt9;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
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

    public String getGroupExt0() {
        return groupExt0;
    }

    public void setGroupExt0(String groupExt0) {
        this.groupExt0 = groupExt0 == null ? null : groupExt0.trim();
    }

    public String getGroupExt1() {
        return groupExt1;
    }

    public void setGroupExt1(String groupExt1) {
        this.groupExt1 = groupExt1 == null ? null : groupExt1.trim();
    }

    public String getGroupExt2() {
        return groupExt2;
    }

    public void setGroupExt2(String groupExt2) {
        this.groupExt2 = groupExt2 == null ? null : groupExt2.trim();
    }

    public String getGroupExt3() {
        return groupExt3;
    }

    public void setGroupExt3(String groupExt3) {
        this.groupExt3 = groupExt3 == null ? null : groupExt3.trim();
    }

    public String getGroupExt4() {
        return groupExt4;
    }

    public void setGroupExt4(String groupExt4) {
        this.groupExt4 = groupExt4 == null ? null : groupExt4.trim();
    }

    public String getGroupExt5() {
        return groupExt5;
    }

    public void setGroupExt5(String groupExt5) {
        this.groupExt5 = groupExt5 == null ? null : groupExt5.trim();
    }

    public String getGroupExt6() {
        return groupExt6;
    }

    public void setGroupExt6(String groupExt6) {
        this.groupExt6 = groupExt6 == null ? null : groupExt6.trim();
    }

    public String getGroupExt7() {
        return groupExt7;
    }

    public void setGroupExt7(String groupExt7) {
        this.groupExt7 = groupExt7 == null ? null : groupExt7.trim();
    }

    public String getGroupExt8() {
        return groupExt8;
    }

    public void setGroupExt8(String groupExt8) {
        this.groupExt8 = groupExt8 == null ? null : groupExt8.trim();
    }

    public String getGroupExt9() {
        return groupExt9;
    }

    public void setGroupExt9(String groupExt9) {
        this.groupExt9 = groupExt9 == null ? null : groupExt9.trim();
    }
}