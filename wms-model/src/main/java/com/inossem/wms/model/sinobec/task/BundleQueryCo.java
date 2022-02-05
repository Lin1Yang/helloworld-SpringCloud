package com.inossem.wms.model.sinobec.task;

import com.inossem.wms.page.PageCommon;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value="com.inossem.wms.model.sinobec.task.BundleQueryCo",description="查询bundle信息入参对象")
public class BundleQueryCo extends PageCommon {

	private String bundleCode;

	private List<SinobecTaskVo> taskList;

	public String getBundleCode() {
		return bundleCode;
	}

	public void setBundleCode(String bundleCode) {
		this.bundleCode = bundleCode;
	}

	public List<SinobecTaskVo> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<SinobecTaskVo> taskList) {
		this.taskList = taskList;
	}
	
	private String whCode;
	private String typeCode;
	private String binCode;
	private String receiptCode;
	private String receiptType;
	private String shippingRef;
	private String corpCode;
	private String heatCode;
	private Byte receiptStatus;
	private Byte soType;
	private String skidCode;

	private String condition;
	private String lotNumb;
	
	private String isEmpty;
	
	public String getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(String isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getHeatCode() {
		return heatCode;
	}

	public void setHeatCode(String heatCode) {
		this.heatCode = heatCode;
	}

	public String getSkidCode() {
		return skidCode;
	}

	public void setSkidCode(String skidCode) {
		this.skidCode = skidCode;
	}

	private  String sDate;
	private  String  eDate;
	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getBinCode() {
		return binCode;
	}

	public void setBinCode(String binCode) {
		this.binCode = binCode;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public String getShippingRef() {
		return shippingRef;
	}

	public void setShippingRef(String shippingRef) {
		this.shippingRef = shippingRef;
	}

	public String getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public Byte getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(Byte receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public Byte getSoType() {
		return soType;
	}

	public void setSoType(Byte soType) {
		this.soType = soType;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getLotNumb() {
		return lotNumb;
	}

	public void setLotNumb(String lotNumb) {
		this.lotNumb = lotNumb;
	}
}
