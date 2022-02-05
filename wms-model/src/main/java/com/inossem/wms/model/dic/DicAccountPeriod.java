package com.inossem.wms.model.dic;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.dic.DicAccountPeriod", description="账期对象")
public class DicAccountPeriod implements Serializable, Comparable<DicAccountPeriod>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "账期id")
    private Integer accountPeriodId;

	@ApiModelProperty(value = "板块编码")
    private Integer boardCode;

	@ApiModelProperty(value = "公司编码")
    private String corpCode;

	@ApiModelProperty(value = "年度")
    private Integer accountYear;

	@ApiModelProperty(value = "月份")
    private Byte accountMonth;

	@ApiModelProperty(value = "起始日期")
    private Date accountBeginDate;

	@ApiModelProperty(value = "终止日期")
    private Date accountEndDate;

	@ApiModelProperty(value = "实际过账日期")
    private Date accountFactDate;

	@ApiModelProperty(value = "0未删除  1已删除")
    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    private String accountPeriodExt0;

    private String accountPeriodExt1;

    private String accountPeriodExt2;

    private String accountPeriodExt3;

    private String accountPeriodExt4;

    private String accountPeriodExt5;

    private String accountPeriodExt6;

    private String accountPeriodExt7;

    private String accountPeriodExt8;

    private String accountPeriodExt9;

    public Integer getAccountPeriodId() {
        return accountPeriodId;
    }

    public void setAccountPeriodId(Integer accountPeriodId) {
        this.accountPeriodId = accountPeriodId;
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

    public Date getAccountBeginDate() {
		return accountBeginDate;
	}

	public void setAccountBeginDate(Date accountBeginDate) {
		this.accountBeginDate = accountBeginDate;
	}

	public Date getAccountEndDate() {
		return accountEndDate;
	}

	public void setAccountEndDate(Date accountEndDate) {
		this.accountEndDate = accountEndDate;
	}

	public Date getAccountFactDate() {
		return accountFactDate;
	}

	public void setAccountFactDate(Date accountFactDate) {
		this.accountFactDate = accountFactDate;
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

    public String getAccountPeriodExt0() {
        return accountPeriodExt0;
    }

    public void setAccountPeriodExt0(String accountPeriodExt0) {
        this.accountPeriodExt0 = accountPeriodExt0 == null ? null : accountPeriodExt0.trim();
    }

    public String getAccountPeriodExt1() {
        return accountPeriodExt1;
    }

    public void setAccountPeriodExt1(String accountPeriodExt1) {
        this.accountPeriodExt1 = accountPeriodExt1 == null ? null : accountPeriodExt1.trim();
    }

    public String getAccountPeriodExt2() {
        return accountPeriodExt2;
    }

    public void setAccountPeriodExt2(String accountPeriodExt2) {
        this.accountPeriodExt2 = accountPeriodExt2 == null ? null : accountPeriodExt2.trim();
    }

    public String getAccountPeriodExt3() {
        return accountPeriodExt3;
    }

    public void setAccountPeriodExt3(String accountPeriodExt3) {
        this.accountPeriodExt3 = accountPeriodExt3 == null ? null : accountPeriodExt3.trim();
    }

    public String getAccountPeriodExt4() {
        return accountPeriodExt4;
    }

    public void setAccountPeriodExt4(String accountPeriodExt4) {
        this.accountPeriodExt4 = accountPeriodExt4 == null ? null : accountPeriodExt4.trim();
    }

    public String getAccountPeriodExt5() {
        return accountPeriodExt5;
    }

    public void setAccountPeriodExt5(String accountPeriodExt5) {
        this.accountPeriodExt5 = accountPeriodExt5 == null ? null : accountPeriodExt5.trim();
    }

    public String getAccountPeriodExt6() {
        return accountPeriodExt6;
    }

    public void setAccountPeriodExt6(String accountPeriodExt6) {
        this.accountPeriodExt6 = accountPeriodExt6 == null ? null : accountPeriodExt6.trim();
    }

    public String getAccountPeriodExt7() {
        return accountPeriodExt7;
    }

    public void setAccountPeriodExt7(String accountPeriodExt7) {
        this.accountPeriodExt7 = accountPeriodExt7 == null ? null : accountPeriodExt7.trim();
    }

    public String getAccountPeriodExt8() {
        return accountPeriodExt8;
    }

    public void setAccountPeriodExt8(String accountPeriodExt8) {
        this.accountPeriodExt8 = accountPeriodExt8 == null ? null : accountPeriodExt8.trim();
    }

    public String getAccountPeriodExt9() {
        return accountPeriodExt9;
    }

    public void setAccountPeriodExt9(String accountPeriodExt9) {
        this.accountPeriodExt9 = accountPeriodExt9 == null ? null : accountPeriodExt9.trim();
    }
    
	@Override
	public int compareTo(DicAccountPeriod o) {
		int i = 0;
		if(this.boardCode.compareTo(o.getBoardCode())==1){
			i=1;
		}else if(this.boardCode.compareTo(o.getBoardCode())==-1){
			i=-1;
		}else{
			if(this.corpCode.compareTo(o.getCorpCode())>0){
				i=1;
			}else if(this.corpCode.compareTo(o.getCorpCode())<0){
				i=-1;
			}else{
				if(this.accountYear.compareTo(o.getAccountYear())==1){
					i=1;
				}else if(this.accountYear.compareTo(o.getAccountYear())==-1){
					i=-1;
				}else{
					
						if(this.accountBeginDate.after(o.getAccountBeginDate())){
							i=1;
						}else if(this.accountBeginDate.before(o.getAccountBeginDate())){
							i=-1;
						}else{
							i=0;
						}
					
				}
			}
		}
		
		return i;
	}
}