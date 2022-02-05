package com.inossem.wms.co.sinobec;

import com.inossem.wms.page.PageCommon;

/**
 * @ClassName SinobecBizInputCo
 * @Description 入库入参
 * @Author wsail
 * @Date 2020/3/24 12:07
 **/
public class SinobecBizInputCo extends PageCommon {

    /**
	 * 
	 */
	private static final long serialVersionUID = 111887853717384866L;

	private Integer inputId;

    private String corpCode;

    private String poCode;

    private String shippingRef;

    private String receiptCode;

    private String receiptRid;

    private Integer receiptType;

    private Byte receiptStatus;

    private String condition;

    private String createStartTime;

    private String createEndTime;

    /*********** 2021-10-07 新增加 ***********/
    private String whCode = "";

    public SinobecBizInputCo () {

    }

    public SinobecBizInputCo(String receiptCode, String receiptRid, Integer receiptType) {
        this.receiptCode = receiptCode;
        this.receiptRid = receiptRid;
        this.receiptType = receiptType;
    }

    public Integer getInputId() {
        return inputId;
    }

    public void setInputId(Integer inputId) {
        this.inputId = inputId;
    }

    public String getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(String createStartTime) {
        this.createStartTime = createStartTime;
    }

    public String getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(String createEndTime) {
        this.createEndTime = createEndTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getReceiptRid() {
        return receiptRid;
    }

    public void setReceiptRid(String receiptRid) {
        this.receiptRid = receiptRid;
    }

    public Integer getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Integer receiptType) {
        this.receiptType = receiptType;
    }

    public Byte getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(Byte receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public String getShippingRef() {
        return shippingRef;
    }

    public void setShippingRef(String shippingRef) {
        this.shippingRef = shippingRef;
    }

    /*********** 2021-10-07 新增加 ***********/
    public String getWhCode() {
        return whCode;
    }

    /*********** 2021-10-07 新增加 ***********/
    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }
}
