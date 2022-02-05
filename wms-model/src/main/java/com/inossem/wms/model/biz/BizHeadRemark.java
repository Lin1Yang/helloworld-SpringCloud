package com.inossem.wms.model.biz;

public class BizHeadRemark {
    private Integer headRemarkId;

    private Integer receiptType;

    private String receiptCode;

    private String receiptRemark;

    public Integer getHeadRemarkId() {
        return headRemarkId;
    }

    public void setHeadRemarkId(Integer headRemarkId) {
        this.headRemarkId = headRemarkId;
    }

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

    public String getReceiptRemark() {
        return receiptRemark;
    }

    public void setReceiptRemark(String receiptRemark) {
        this.receiptRemark = receiptRemark == null ? null : receiptRemark.trim();
    }
}