package com.inossem.wms.model.biz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.biz.BizReceiptOperationLogVo", description="操作日志列表对象")
public class BizReceiptOperationLogVo extends BizReceiptOperationLog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4222607040951936443L;

	@ApiModelProperty(value="单据类型名称", example="销售出库")
	private String receiptTypeName;

	@ApiModelProperty(value="操作名称", example="创建")
	private String receiptOperationTypeName;

	@ApiModelProperty(value="创建人名称", example="李四")
	private String createUserName;

	@ApiModelProperty(value="总数量")
    private int totalCount;
	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount=totalCount;
		
	}

	public String getReceiptTypeName() {
		return receiptTypeName;
	}

	public void setReceiptTypeName(String receiptTypeName) {
		this.receiptTypeName = receiptTypeName;
	}

	public String getReceiptOperationTypeName() {
		return receiptOperationTypeName;
	}

	public void setReceiptOperationTypeName(String receiptOperationTypeName) {
		this.receiptOperationTypeName = receiptOperationTypeName;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}




}