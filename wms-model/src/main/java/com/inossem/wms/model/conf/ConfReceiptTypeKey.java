package com.inossem.wms.model.conf;

import com.inossem.wms.page.PageCommon;

public class ConfReceiptTypeKey extends PageCommon {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7722173192941569316L;

	private String confReceiptTypeCode;

    private Integer receiptType;

    public String getConfReceiptTypeCode() {
        return confReceiptTypeCode;
    }

    public void setConfReceiptTypeCode(String confReceiptTypeCode) {
        this.confReceiptTypeCode = confReceiptTypeCode == null ? null : confReceiptTypeCode.trim();
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }
}