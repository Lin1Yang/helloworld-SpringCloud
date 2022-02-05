package com.inossem.wms.co.dic;

import java.util.List;

import com.inossem.wms.model.dic.DicCorp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 公司输提交参数类
 * @author Gyl
 */
@ApiModel(value="com.inossem.wms.co.dic.DicCorpCo", description="这是公司信息映射类")
public class DicCorpCo extends DicCorp {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6661152208172473789L;
	/**
	 * 公司代码
	 */
    @ApiModelProperty(value="公司代码", name="corpCode", example="9000", required=true)
    private String corpCode;
	/**
	 * 公司名称
	 */
	@ApiModelProperty(value="公司名称国际化编码", name="corpName", example="i18n_0000000001_tid", required=true)
	private String corpName;
	/**
	 *公司描述
	 */
	@ApiModelProperty(value="国际化语言设置列表", name="dicTextList", required=true, reference = "com.inossem.wms.co.dic.DicTextCo")
	private List<DicTextCo> dicTextList;
	/**
	 *归属板块
	 *  1-煤制油板块
	 * 	2-煤炭板块
	 * 	3-铁路板块
	 * 	4-其他板块
	 */
	@ApiModelProperty(value="归属板块", name="boardCode", example="1", required=false)
	private Integer boardCode;
	/**
	 *公司税号
	 */
	@ApiModelProperty(value="公司税号", name="corpTaxNo", example="1", required=false)
	private String corpTaxNo;
	/**
	 *开户行
	 */
	@ApiModelProperty(value="开户行", name="bankOfDeposit", example="1", required=false)
	private String bankOfDeposit;
	/**
	 *银行账户
	 */
	@ApiModelProperty(value="银行账户", name="bankAccount", example="1", required=false)
	private String bankAccount;
	/**
	 *公司地址
	 */
	@ApiModelProperty(value="公司地址", name="corpAddress", example="1", required=false)
	private String corpAddress;
	/**
	 *公司账号
	 */
	@ApiModelProperty(value="公司账号", name="corpTel", example="1", required=false)
	private String corpTel;



	public DicCorpCo(String corpCode, String corpName, List<DicTextCo> dicTextList, Integer boardCode, String corpTaxNo, String bankOfDeposit, String bankAccount, String corpAddress, String corpTel) {
		this.corpCode = corpCode;
		this.corpName = corpName;
		this.dicTextList = dicTextList;
		this.boardCode = boardCode;
		this.corpTaxNo = corpTaxNo;
		this.bankOfDeposit = bankOfDeposit;
		this.bankAccount = bankAccount;
		this.corpAddress = corpAddress;
		this.corpTel = corpTel;
	}

	@Override
	public String getCorpCode() {
		return corpCode;
	}

	@Override
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	@Override
	public String getCorpName() {
		return corpName;
	}
	@Override
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public DicCorpCo() {
	}

	public List<DicTextCo> getDicTextList() {
		return dicTextList;
	}

	public void setDicTextList(List<DicTextCo> dicTextList) {
		this.dicTextList = dicTextList;
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
		this.corpTaxNo = corpTaxNo;
	}

	@Override
	public String getBankOfDeposit() {
		return bankOfDeposit;
	}

	@Override
	public void setBankOfDeposit(String bankOfDeposit) {
		this.bankOfDeposit = bankOfDeposit;
	}

	@Override
	public String getBankAccount() {
		return bankAccount;
	}

	@Override
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String getCorpAddress() {
		return corpAddress;
	}

	@Override
	public void setCorpAddress(String corpAddress) {
		this.corpAddress = corpAddress;
	}

	@Override
	public String getCorpTel() {
		return corpTel;
	}

	@Override
	public void setCorpTel(String corpTel) {
		this.corpTel = corpTel;
	}

	@Override
	public String toString() {
		return "DicCorpCo{" +
				"corpCode='" + corpCode + '\'' +
				", coprName='" + corpName + '\'' +
				", dicTextList=" + dicTextList +
				", boardCode=" + boardCode +
				", corpTaxNo='" + corpTaxNo + '\'' +
				", bankOfDeposit='" + bankOfDeposit + '\'' +
				", bankAccount='" + bankAccount + '\'' +
				", corpAddress='" + corpAddress + '\'' +
				", corpTel='" + corpTel + '\'' +
				'}';
	}
}
