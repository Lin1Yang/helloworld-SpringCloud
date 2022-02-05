package com.inossem.wms.model.dic;

public class DicReceiptType {
    private Integer receiptType;

    private String receiptTypeName;

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptTypeName() {
        return receiptTypeName;
    }

    public void setReceiptTypeName(String receiptTypeName) {
        this.receiptTypeName = receiptTypeName == null ? null : receiptTypeName.trim();
    }
}