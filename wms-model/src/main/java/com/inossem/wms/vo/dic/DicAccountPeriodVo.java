package com.inossem.wms.vo.dic;

import java.io.Serializable;

import com.inossem.wms.model.dic.DicAccountPeriod;
import com.inossem.wms.page.IPageResultCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.dic.DicAccountPeriodVo", description="账期出参对象")
public class DicAccountPeriodVo extends DicAccountPeriod implements IPageResultCommon,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "总记录数")
	private int totalCount;

	@ApiModelProperty(value = "板块描述")
    private String boardName;
	
	@ApiModelProperty(value = "公司描述")
    private String corpName;
	
	@ApiModelProperty(value = "创建人名称")
    private String createUserName;

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
