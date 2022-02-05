package com.inossem.wms.model.dic;

import java.io.Serializable;
import java.util.Date;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author GYL
 */
@ApiModel(value="com.inossem.wms.model.dic.DicCorp", description="这是公司信息映射类")
public class DicCorp extends PageCommon implements Serializable {
    
	private static final long serialVersionUID = 3715721442731419923L;
	@ApiModelProperty(value="公司代码", name="corpCode", example="9000", required=true)
    private String corpCode;
    @ApiModelProperty(value="公司名称国际化编码(公司描述)", name="corpName", example="i18n_0000000001_tid", required=true)
    private String corpName;
    @ApiModelProperty(value="所在城市", name="city", example="1", required=false)
    private String city;
    @ApiModelProperty(value="归属板块", name="boardCode", example="1", required=false)
    private Integer boardCode;
    @ApiModelProperty(value="公司税号", name="corpTaxNo", example="1", required=false)
    private String corpTaxNo;
    @ApiModelProperty(value="开户行", name="bankOfDeposit", example="1", required=false)
    private String bankOfDeposit;
    @ApiModelProperty(value="银行账户", name="bankAccount", example="1", required=false)
    private String bankAccount;
    @ApiModelProperty(value="公司地址", name="corpAddress", example="1", required=false)
    private String corpAddress;
    @ApiModelProperty(value="公司电话", name="corpTel", example="1", required=false)
    private String corpTel;
    @ApiModelProperty(value="是否启用账期管理 0不启用  1启用", name="isAccountPeriod")
    private Byte isAccountPeriod;
    @ApiModelProperty(value="是否过账日期提醒 0不提醒  1提醒", name="isDateRemind")
    private Byte isDateRemind;
    @ApiModelProperty(value="是否过账日期修改 0不可修改  1可修改", name="isDateEdit")
    private Byte isDateEdit;
    @ApiModelProperty(value="删除标识", name="isDelete")
    private Byte isDelete;

    @ApiModelProperty(value="创建时间", name="createTime")
    private Date createTime;

    @ApiModelProperty(value="修改时间", name="modifyTime")
    private Date modifyTime;

    @ApiModelProperty(value="创建人员ID", name="createUserId")
    private Integer createUserId;

    @ApiModelProperty(value="修改人员ID", name="modifyUserId")
    private Integer modifyUserId;

    @ApiModelProperty(value="预留字段", name="corpExt0")
    private String corpExt0;

    @ApiModelProperty(value="预留字段", name="corpExt1")
    private String corpExt1;

    @ApiModelProperty(value="预留字段", name="corpExt2")
    private String corpExt2;

    @ApiModelProperty(value="预留字段", name="corpExt3")
    private String corpExt3;

    @ApiModelProperty(value="预留字段", name="corpExt4")
    private String corpExt4;

    @ApiModelProperty(value="预留字段", name="corpExt5")
    private String corpExt5;

    @ApiModelProperty(value="预留字段", name="corpExt6")
    private String corpExt6;

    @ApiModelProperty(value="预留字段", name="corpExt7")
    private String corpExt7;

    @ApiModelProperty(value="预留字段", name="corpExt8")
    private String corpExt8;

    @ApiModelProperty(value="预留字段", name="corpExt9")
    private String corpExt9;

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(Integer boardCode) {
        this.boardCode = boardCode;
    }

    public String getCorpTaxNo() {
        return corpTaxNo;
    }

    public void setCorpTaxNo(String corpTaxNo) {
        this.corpTaxNo = corpTaxNo == null ? null : corpTaxNo.trim();
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit == null ? null : bankOfDeposit.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getCorpAddress() {
        return corpAddress;
    }

    public void setCorpAddress(String corpAddress) {
        this.corpAddress = corpAddress == null ? null : corpAddress.trim();
    }

    public String getCorpTel() {
        return corpTel;
    }

    public void setCorpTel(String corpTel) {
        this.corpTel = corpTel == null ? null : corpTel.trim();
    }  

    public Byte getIsAccountPeriod() {
		return isAccountPeriod;
	}

	public void setIsAccountPeriod(Byte isAccountPeriod) {
		this.isAccountPeriod = isAccountPeriod;
	}

	public Byte getIsDateRemind() {
		return isDateRemind;
	}

	public void setIsDateRemind(Byte isDateRemind) {
		this.isDateRemind = isDateRemind;
	}

	public Byte getIsDateEdit() {
		return isDateEdit;
	}

	public void setIsDateEdit(Byte isDateEdit) {
		this.isDateEdit = isDateEdit;
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

    public String getCorpExt0() {
        return corpExt0;
    }

    public void setCorpExt0(String corpExt0) {
        this.corpExt0 = corpExt0 == null ? null : corpExt0.trim();
    }

    public String getCorpExt1() {
        return corpExt1;
    }

    public void setCorpExt1(String corpExt1) {
        this.corpExt1 = corpExt1 == null ? null : corpExt1.trim();
    }

    public String getCorpExt2() {
        return corpExt2;
    }

    public void setCorpExt2(String corpExt2) {
        this.corpExt2 = corpExt2 == null ? null : corpExt2.trim();
    }

    public String getCorpExt3() {
        return corpExt3;
    }

    public void setCorpExt3(String corpExt3) {
        this.corpExt3 = corpExt3 == null ? null : corpExt3.trim();
    }

    public String getCorpExt4() {
        return corpExt4;
    }

    public void setCorpExt4(String corpExt4) {
        this.corpExt4 = corpExt4 == null ? null : corpExt4.trim();
    }

    public String getCorpExt5() {
        return corpExt5;
    }

    public void setCorpExt5(String corpExt5) {
        this.corpExt5 = corpExt5 == null ? null : corpExt5.trim();
    }

    public String getCorpExt6() {
        return corpExt6;
    }

    public void setCorpExt6(String corpExt6) {
        this.corpExt6 = corpExt6 == null ? null : corpExt6.trim();
    }

    public String getCorpExt7() {
        return corpExt7;
    }

    public void setCorpExt7(String corpExt7) {
        this.corpExt7 = corpExt7 == null ? null : corpExt7.trim();
    }

    public String getCorpExt8() {
        return corpExt8;
    }

    public void setCorpExt8(String corpExt8) {
        this.corpExt8 = corpExt8 == null ? null : corpExt8.trim();
    }

    public String getCorpExt9() {
        return corpExt9;
    }

    public void setCorpExt9(String corpExt9) {
        this.corpExt9 = corpExt9 == null ? null : corpExt9.trim();
    }
}