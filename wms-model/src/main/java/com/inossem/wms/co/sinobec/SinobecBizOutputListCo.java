package com.inossem.wms.co.sinobec;

import com.inossem.wms.page.PageCommon;

public class SinobecBizOutputListCo extends PageCommon {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5180673113152987424L;
	
	private String corpCode;

    private String soCode;

    private String shippingRef;

    private String receiptCode;

    private Integer receiptType;

    private Byte receiptStatus;

    private String createStartTime;

    private String createEndTime;

	private String whCode;     //2021-10-07 新加

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getSoCode() {
		return soCode;
	}

	public void setSoCode(String soCode) {
		this.soCode = soCode;
	}

	public String getShippingRef() {
		return shippingRef;
	}

	public void setShippingRef(String shippingRef) {
		this.shippingRef = shippingRef;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
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


	public String getWhCode() {
		return whCode;
	}     //2021-10-07 新加

	public void setWhCode(String whCode) {     //2021-10-07 新加
		this.whCode = whCode;
	}
	

}
