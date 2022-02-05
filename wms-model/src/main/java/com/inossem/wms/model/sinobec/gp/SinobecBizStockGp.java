package com.inossem.wms.model.sinobec.gp;

import java.math.BigDecimal;
import java.util.Date;

public class SinobecBizStockGp {

    private String bundleCode;

    private String heatCode;

    private String skidCode;

    private String shippingRef;

    private String poCode;

    private String poRid;

    private String matCode;

    private String matName;

    private String weightUnitCode;

    private BigDecimal weightQty;

    private String receiptUnitCode;

    private BigDecimal receiptQty;

    private String corpCode;

    private String whCode;

    private String itemNumb;

    private String itemDesc;

    private String lotNumb;

    private String stockStatus;

    private Date inputDate;

    public String getBundleCode() {
        return bundleCode;
    }

    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode == null ? null : bundleCode.trim();
    }

    public String getHeatCode() {
        return heatCode;
    }

    public void setHeatCode(String heatCode) {
        this.heatCode = heatCode == null ? null : heatCode.trim();
    }

    public String getSkidCode() {
        return skidCode;
    }

    public void setSkidCode(String skidCode) {
        this.skidCode = skidCode == null ? null : skidCode.trim();
    }

    public String getShippingRef() {
        return shippingRef;
    }

    public void setShippingRef(String shippingRef) {
        this.shippingRef = shippingRef == null ? null : shippingRef.trim();
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode == null ? null : poCode.trim();
    }

    public String getPoRid() {
        return poRid;
    }

    public void setPoRid(String poRid) {
        this.poRid = poRid == null ? null : poRid.trim();
    }

    public String getMatCode() {
        return matCode;
    }

    public void setMatCode(String matCode) {
        this.matCode = matCode == null ? null : matCode.trim();
    }

    public String getWeightUnitCode() {
        return weightUnitCode;
    }

    public void setWeightUnitCode(String weightUnitCode) {
        this.weightUnitCode = weightUnitCode == null ? null : weightUnitCode.trim();
    }

    public BigDecimal getWeightQty() {
        return weightQty;
    }

    public void setWeightQty(BigDecimal weightQty) {
        this.weightQty = weightQty;
    }

    public String getReceiptUnitCode() {
        return receiptUnitCode;
    }

    public void setReceiptUnitCode(String receiptUnitCode) {
        this.receiptUnitCode = receiptUnitCode == null ? null : receiptUnitCode.trim();
    }

    public BigDecimal getReceiptQty() {
        return receiptQty;
    }

    public void setReceiptQty(BigDecimal receiptQty) {
        this.receiptQty = receiptQty;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode == null ? null : whCode.trim();
    }

    public String getItemNumb() {
        return itemNumb;
    }

    public void setItemNumb(String itemNumb) {
        this.itemNumb = itemNumb == null ? null : itemNumb.trim();
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    public String getLotNumb() {
        return lotNumb;
    }

    public void setLotNumb(String lotNumb) {
        this.lotNumb = lotNumb == null ? null : lotNumb.trim();
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus == null ? null : stockStatus.trim();
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }
}