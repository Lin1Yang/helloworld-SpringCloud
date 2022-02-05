package com.inossem.wms.vo.sinobec;

import java.util.List;

import com.inossem.wms.model.sinobec.task.SinobecTaskVo;

public class SinobecTaskHeadVo {

	
	private String receiptCode;
	
	private Byte receiptStatus;
	
	private String receiptStatusName;
	
	private List<SinobecTaskVo> itemList;

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public String getReceiptStatusName() {
		return receiptStatusName;
	}

	public void setReceiptStatusName(String receiptStatusName) {
		this.receiptStatusName = receiptStatusName;
	}

	public List<SinobecTaskVo> getItemList() {
		return itemList;
	}

	public void setItemList(List<SinobecTaskVo> itemList) {
		this.itemList = itemList;
	}
	
	
	
	
}
