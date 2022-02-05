package com.inossem.wms.model.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicAccountPeriodKey", description="账期唯一键对象")
public class DicAccountPeriodKey {	
	
	@ApiModelProperty(value = "板块编码")
    private Integer boardCode;

	@ApiModelProperty(value = "公司编码")
    private String corpCode;

	@ApiModelProperty(value = "年度")
    private Integer accountYear;

	@ApiModelProperty(value = "月份")
    private Byte accountMonth;
	
	public DicAccountPeriodKey() {
		
	}
	
	public DicAccountPeriodKey(Integer boardCode,String corpCode,Integer accountYear,Byte accountMonth) {
		this.boardCode = boardCode;
		this.corpCode = corpCode;
		this.accountYear = accountYear;
		this.accountMonth = accountMonth;
	}
	
    public Integer getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(Integer boardCode) {
        this.boardCode = boardCode;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public Integer getAccountYear() {
        return accountYear;
    }

    public void setAccountYear(Integer accountYear) {
        this.accountYear = accountYear;
    }

    public Byte getAccountMonth() {
        return accountMonth;
    }

    public void setAccountMonth(Byte accountMonth) {
        this.accountMonth = accountMonth;
    }

    

}
