package com.inossem.wms.model.sinobec.task;

import java.util.Date;
import java.util.List;

import com.inossem.wms.page.PageCommon;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "com.inossem.wms.model.sinobec.task.SinobecTaskQueryCo",description="作业但列表查询入参对象，支持分页")
public class SinobecTaskQueryCo extends PageCommon {

	/**
	 * 
	 */
	private static final long serialVersionUID = 113663235621560045L;

	private Integer taskType;
	
	private Date startTime;
	
	private Date endTime;
	
	private String receiptCode;
	
	private Integer receiptType;
	
	private String bundleCode;
	
	private String shippingRef;
	
	private Byte receiptStatus;
	
	private String receiptTypeString;
	
	private List<Byte> receiptStatusList;

	private String whCode;     //2021-10-07  新加

	
	public String getReceiptTypeString() {
		return receiptTypeString;
	}

	public void setReceiptTypeString(String receiptTypeString) {
		this.receiptTypeString = receiptTypeString;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public String getBundleCode() {
		return bundleCode;
	}

	public void setBundleCode(String bundleCode) {
		this.bundleCode = bundleCode;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public String getShippingRef() {
		return shippingRef;
	}

	public void setShippingRef(String shippingRef) {
		this.shippingRef = shippingRef;
	}

	public List<Byte> getReceiptStatusList() {
		return receiptStatusList;
	}

	public void setReceiptStatusList(List<Byte> receiptStatusList) {
		this.receiptStatusList = receiptStatusList;
	}

	public String getWhCode() {
		return whCode;
	}        //2021-10-07  新加

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}    //2021-10-07  新加

}
