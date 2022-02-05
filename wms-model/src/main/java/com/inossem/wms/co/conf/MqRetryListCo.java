package com.inossem.wms.co.conf;

import java.util.Date;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.conf.MqRetryListCo", description="Mq推送重试列表查询")
public class MqRetryListCo extends PageCommon {
	
	private static final long serialVersionUID = -5610717134032229342L;
	
	@ApiModelProperty(value="是否已处理", example="0", required=false)
	private Byte isProcessed;

	/** 检索的关键字 */
	@ApiModelProperty(value="检索的关键字", example="CK02002064", required=false)
	private String searchKeywords;
	
	@ApiModelProperty(value="查询起始日期", example="2018-12-22", required=false)
	private Date createTimeStart;
	
	@ApiModelProperty(value="查询截至日期", example="2018-12-23", required=false)
	private Date createTimeEnd;
	
	public Byte getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(Byte isProcessed) {
		this.isProcessed = isProcessed;
	}

	public String getSearchKeywords() {
		return searchKeywords;
	}

	public void setSearchKeywords(String searchKeywords) {
		this.searchKeywords = searchKeywords;
	}

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
}
