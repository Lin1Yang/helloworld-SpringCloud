package com.inossem.wms.model.biz;

import com.inossem.wms.page.PageCommon;

public class BizReceiptActorKey extends PageCommon {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6970303577228840634L;

	private Integer receiptType;

    private String receiptCode;

    private String postCode;

    private Integer operatorId;

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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}