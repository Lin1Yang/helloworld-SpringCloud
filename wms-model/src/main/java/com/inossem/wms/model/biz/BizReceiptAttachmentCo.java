package com.inossem.wms.model.biz;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.model.biz.BizReceiptAttachmentCo", description="单据附件查询参数")
public class BizReceiptAttachmentCo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7124578561663511269L;

	@ApiModelProperty(value="单据类型", name="receiptType", example="10", required=true)
    private Integer receiptType;
	
	@ApiModelProperty(value="单据编码", name="receiptCode", example="1000000001", required=true)
    private String receiptCode;
	
	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}


}
