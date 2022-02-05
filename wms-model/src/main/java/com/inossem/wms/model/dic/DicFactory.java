package com.inossem.wms.model.dic;

import java.io.Serializable;
import java.util.Date;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class DicFactory extends PageCommon implements Serializable {
    
	private static final long serialVersionUID = 7902283339821770759L;
	@ApiModelProperty(value="工厂代码", name="ftyCode", example="9000", required=true)
    private String ftyCode;
    @ApiModelProperty(value="公司代码", name="corpCode",  required=true)
    private String corpCode;
    @ApiModelProperty(value="工厂国际化编码", name="ftyName",  required=true)
    private String ftyName;
    @ApiModelProperty(value="虚拟标记", name="ftyVirtualIdentification",  required=true)
    private Byte ftyVirtualIdentification;
    @ApiModelProperty(value="启用erp批次", name="ftyBatchErpEnabled",  required=true)
    private Byte ftyBatchErpEnabled;
    @ApiModelProperty(value="启用生产批次", name="ftyBatchProductEnabled",  required=true)
    private Byte ftyBatchProductEnabled;
    @ApiModelProperty(value="启用包", name="ftyPackageEnabled",  required=true)
    private Byte ftyPackageEnabled;
    @ApiModelProperty(value="地址", name="address",  required=true)
    private String address;
    @ApiModelProperty(value="删除标记", name="isDelete",  required=true)
    private Byte isDelete;
    @ApiModelProperty(value="创建时间", name="createTime",  required=true)
    private Date createTime;
    @ApiModelProperty(value="编辑时间", name="modifyTime",  required=true)
    private Date modifyTime;
    @ApiModelProperty(value="创建用户ID", name="createUserId",  required=true)
    private Integer createUserId;
    @ApiModelProperty(value="编辑用户ID", name="modifyUserId",  required=true)
    private Integer modifyUserId;
    @ApiModelProperty(value="预留字段", name="ftyExt0")
    private String ftyExt0;
    @ApiModelProperty(value="预留字段", name="ftyExt1")
    private String ftyExt1;
    @ApiModelProperty(value="预留字段", name="ftyExt2")
    private String ftyExt2;
    @ApiModelProperty(value="预留字段", name="ftyExt3")
    private String ftyExt3;
    @ApiModelProperty(value="预留字段", name="ftyExt4")
    private String ftyExt4;
    @ApiModelProperty(value="预留字段", name="ftyExt5")
    private String ftyExt5;
    @ApiModelProperty(value="预留字段", name="ftyExt6")
    private String ftyExt6;
    @ApiModelProperty(value="预留字段", name="ftyExt7")
    private String ftyExt7;
    @ApiModelProperty(value="预留字段", name="ftyExt8")
    private String ftyExt8;
    @ApiModelProperty(value="预留字段", name="ftyExt9")
    private String ftyExt9;

    public String getFtyCode() {
        return ftyCode;
    }

    public void setFtyCode(String ftyCode) {
        this.ftyCode = ftyCode == null ? null : ftyCode.trim();
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getFtyName() {
        return ftyName;
    }

    public void setFtyName(String ftyName) {
        this.ftyName = ftyName == null ? null : ftyName.trim();
    }

    public Byte getFtyVirtualIdentification() {
        return ftyVirtualIdentification;
    }

    public void setFtyVirtualIdentification(Byte ftyVirtualIdentification) {
        this.ftyVirtualIdentification = ftyVirtualIdentification;
    }

    public Byte getFtyBatchErpEnabled() {
        return ftyBatchErpEnabled;
    }

    public void setFtyBatchErpEnabled(Byte ftyBatchErpEnabled) {
        this.ftyBatchErpEnabled = ftyBatchErpEnabled;
    }

    public Byte getFtyBatchProductEnabled() {
        return ftyBatchProductEnabled;
    }

    public void setFtyBatchProductEnabled(Byte ftyBatchProductEnabled) {
        this.ftyBatchProductEnabled = ftyBatchProductEnabled;
    }

    public Byte getFtyPackageEnabled() {
        return ftyPackageEnabled;
    }

    public void setFtyPackageEnabled(Byte ftyPackageEnabled) {
        this.ftyPackageEnabled = ftyPackageEnabled;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getFtyExt0() {
        return ftyExt0;
    }

    public void setFtyExt0(String ftyExt0) {
        this.ftyExt0 = ftyExt0 == null ? null : ftyExt0.trim();
    }

    public String getFtyExt1() {
        return ftyExt1;
    }

    public void setFtyExt1(String ftyExt1) {
        this.ftyExt1 = ftyExt1 == null ? null : ftyExt1.trim();
    }

    public String getFtyExt2() {
        return ftyExt2;
    }

    public void setFtyExt2(String ftyExt2) {
        this.ftyExt2 = ftyExt2 == null ? null : ftyExt2.trim();
    }

    public String getFtyExt3() {
        return ftyExt3;
    }

    public void setFtyExt3(String ftyExt3) {
        this.ftyExt3 = ftyExt3 == null ? null : ftyExt3.trim();
    }

    public String getFtyExt4() {
        return ftyExt4;
    }

    public void setFtyExt4(String ftyExt4) {
        this.ftyExt4 = ftyExt4 == null ? null : ftyExt4.trim();
    }

    public String getFtyExt5() {
        return ftyExt5;
    }

    public void setFtyExt5(String ftyExt5) {
        this.ftyExt5 = ftyExt5 == null ? null : ftyExt5.trim();
    }

    public String getFtyExt6() {
        return ftyExt6;
    }

    public void setFtyExt6(String ftyExt6) {
        this.ftyExt6 = ftyExt6 == null ? null : ftyExt6.trim();
    }

    public String getFtyExt7() {
        return ftyExt7;
    }

    public void setFtyExt7(String ftyExt7) {
        this.ftyExt7 = ftyExt7 == null ? null : ftyExt7.trim();
    }

    public String getFtyExt8() {
        return ftyExt8;
    }

    public void setFtyExt8(String ftyExt8) {
        this.ftyExt8 = ftyExt8 == null ? null : ftyExt8.trim();
    }

    public String getFtyExt9() {
        return ftyExt9;
    }

    public void setFtyExt9(String ftyExt9) {
        this.ftyExt9 = ftyExt9 == null ? null : ftyExt9.trim();
    }
}