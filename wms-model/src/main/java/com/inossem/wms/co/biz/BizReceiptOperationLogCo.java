package com.inossem.wms.co.biz;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="com.inossem.wms.co.biz.BizReceiptOperationLogCo", description="操作日志查询条件对象")
public class BizReceiptOperationLogCo  extends PageCommon{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7319228869783866880L;

	@ApiModelProperty(value="单据类型", example="1")
	private Integer receiptType;

	@ApiModelProperty(value="操作类型", example="10")
	private Byte receiptOperationType;

	@ApiModelProperty(value="创建时间", example="2018-01-01")
	private String startTime;
	@ApiModelProperty(value="结束时间", example="2018-01-01")
	private String endTime;

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public Byte getReceiptOperationType() {
		return receiptOperationType;
	}

	public void setReceiptOperationType(Byte receiptOperationType) {
		this.receiptOperationType = receiptOperationType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


}