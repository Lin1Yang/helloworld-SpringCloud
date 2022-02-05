package com.inossem.wms.vo.dic;

import java.util.Date;
import java.util.List;

import com.inossem.wms.model.dic.DicCorp;
import com.inossem.wms.model.dic.DicText;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author admin
 */
@ApiModel(value="com.inossem.wms.vo.dic.DicCorpVo", description="公司")
public class DicCorpVo extends DicCorp{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6844581558568419967L;

	private String corpCode;

    private String corpName;

    private String city;
    private Integer userId;
    private Integer boardCode;
    private String boardName;

    private String corpTaxNo;

    private String bankOfDeposit;

    private String bankAccount;

    private String corpAddress;

    private String corpTel;

    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;
    
  
    
    @ApiModelProperty(value="部门集合", name="depVotList", required=true)
    private List<DicDeptVo> depVotList;
    @ApiModelProperty(value="已配置语言集合", name="dicTextList", required=true)
    private List<DicText> dicTextList;


    @Override
    public String getCorpCode() {
        return corpCode;
    }

    @Override
    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    @Override
    public String getCorpName() {
        return corpName;
    }

    @Override
    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    @Override
    public Integer getBoardCode() {
        return boardCode;
    }

    @Override
    public void setBoardCode(Integer boardCode) {
        this.boardCode = boardCode;
    }

    @Override
    public String getCorpTaxNo() {
        return corpTaxNo;
    }

    @Override
    public void setCorpTaxNo(String corpTaxNo) {
        this.corpTaxNo = corpTaxNo == null ? null : corpTaxNo.trim();
    }

    @Override
    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    @Override
    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit == null ? null : bankOfDeposit.trim();
    }

    @Override
    public String getBankAccount() {
        return bankAccount;
    }

    @Override
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    @Override
    public String getCorpAddress() {
        return corpAddress;
    }

    @Override
    public void setCorpAddress(String corpAddress) {
        this.corpAddress = corpAddress == null ? null : corpAddress.trim();
    }

    @Override
    public String getCorpTel() {
        return corpTel;
    }

    @Override
    public void setCorpTel(String corpTel) {
        this.corpTel = corpTel == null ? null : corpTel.trim();
    }

    @Override
    public Byte getIsDelete() {
        return isDelete;
    }

    @Override
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getModifyTime() {
        return modifyTime;
    }

    @Override
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public Integer getCreateUserId() {
        return createUserId;
    }

    @Override
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    @Override
    public Integer getModifyUserId() {
        return modifyUserId;
    }

    @Override
    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

	

	public List<DicDeptVo> getDepVotList() {
		return depVotList;
	}

	public void setDepVotList(List<DicDeptVo> depVotList) {
		this.depVotList = depVotList;
	}

    public List<DicText> getDicTextList() {
        return dicTextList;
    }

    public void setDicTextList(List<DicText> dicTextList) {
        this.dicTextList = dicTextList;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}