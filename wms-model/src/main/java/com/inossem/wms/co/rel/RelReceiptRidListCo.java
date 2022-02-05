package com.inossem.wms.co.rel;

import java.util.List;

public class RelReceiptRidListCo {
	private Integer receiptType; 
	private String receiptCode; 
	private List<String> ridList;
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
	public List<String> getRidList() {
		return ridList;
	}
	public void setRidList(List<String> ridList) {
		this.ridList = ridList;
	}
	
	

}
