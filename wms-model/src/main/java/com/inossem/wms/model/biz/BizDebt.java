package com.inossem.wms.model.biz;

import java.math.BigDecimal;
import java.util.Date;

public class BizDebt {
    private Integer debtId;

    private Byte debtType;

    private Integer receiptType;

    private String receiptCode;

    private String receiptRid;

    private String receiptBid;

    private String batch;

    private String matCode;

    private String ftyCode;

    private String locationCode;

    private BigDecimal qty;

    private Byte isDelete;

    private Date createTime;

    private Date modifyTime;

    private Integer createUserId;

    private Integer modifyUserId;

    private String debtExt0;

    private String debtExt1;

    private String debtExt2;

    private String debtExt3;

    private String debtExt4;

    private String debtExt5;

    private String debtExt6;

    private String debtExt7;

    private String debtExt8;

    private String debtExt9;
    
    public BizDebt(){
    	this.receiptBid = "";
    }

    public Integer getDebtId() {
        return debtId;
    }

    public void setDebtId(Integer debtId) {
        this.debtId = debtId;
    }

    public Byte getDebtType() {
        return debtType;
    }

    public void setDebtType(Byte debtType) {
        this.debtType = debtType;
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

    public String getReceiptRid() {
        return receiptRid;
    }

    public void setReceiptRid(String receiptRid) {
        this.receiptRid = receiptRid == null ? null : receiptRid.trim();
    }

    public String getReceiptBid() {
        return receiptBid;
    }

    public void setReceiptBid(String receiptBid) {
        this.receiptBid = receiptBid == null ? null : receiptBid.trim();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public String getFtyCode() {
        return ftyCode;
    }

    public void setFtyCode(String ftyCode) {
        this.ftyCode = ftyCode == null ? null : ftyCode.trim();
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode == null ? null : locationCode.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getDebtExt0() {
        return debtExt0;
    }

    public void setDebtExt0(String debtExt0) {
        this.debtExt0 = debtExt0 == null ? null : debtExt0.trim();
    }

    public String getDebtExt1() {
        return debtExt1;
    }

    public void setDebtExt1(String debtExt1) {
        this.debtExt1 = debtExt1 == null ? null : debtExt1.trim();
    }

    public String getDebtExt2() {
        return debtExt2;
    }

    public void setDebtExt2(String debtExt2) {
        this.debtExt2 = debtExt2 == null ? null : debtExt2.trim();
    }

    public String getDebtExt3() {
        return debtExt3;
    }

    public void setDebtExt3(String debtExt3) {
        this.debtExt3 = debtExt3 == null ? null : debtExt3.trim();
    }

    public String getDebtExt4() {
        return debtExt4;
    }

    public void setDebtExt4(String debtExt4) {
        this.debtExt4 = debtExt4 == null ? null : debtExt4.trim();
    }

    public String getDebtExt5() {
        return debtExt5;
    }

    public void setDebtExt5(String debtExt5) {
        this.debtExt5 = debtExt5 == null ? null : debtExt5.trim();
    }

    public String getDebtExt6() {
        return debtExt6;
    }

    public void setDebtExt6(String debtExt6) {
        this.debtExt6 = debtExt6 == null ? null : debtExt6.trim();
    }

    public String getDebtExt7() {
        return debtExt7;
    }

    public void setDebtExt7(String debtExt7) {
        this.debtExt7 = debtExt7 == null ? null : debtExt7.trim();
    }

    public String getDebtExt8() {
        return debtExt8;
    }

    public void setDebtExt8(String debtExt8) {
        this.debtExt8 = debtExt8 == null ? null : debtExt8.trim();
    }

    public String getDebtExt9() {
        return debtExt9;
    }

    public void setDebtExt9(String debtExt9) {
        this.debtExt9 = debtExt9 == null ? null : debtExt9.trim();
    }
}