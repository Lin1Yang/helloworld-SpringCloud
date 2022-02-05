package com.inossem.wms.model.wf;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "审批单据主键映射类")
public class WfReceiptKey implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(name="receiptType",value = "单据类型",required = true)
    private Integer receiptType;
    @ApiModelProperty(name="receiptCode",value = "单据编号",required = true)
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
        this.receiptCode = receiptCode == null ? null : receiptCode.trim();
    }
}