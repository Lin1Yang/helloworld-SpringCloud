package com.inossem.wms.model.sinobec.task;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value="com.inossem.wms.model.sinobec.task.SinobecTaskSubmitCo",description="提交作业单入参对象")
public class SinobecTaskSubmitCo {

	private Integer createUserId;
	
	private Integer taskType;
	
	private List<SinobecTaskVo> taskList;
	
	private Byte isSubmit;
	
	private String receiptCode;

	public List<SinobecTaskVo> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<SinobecTaskVo> taskList) {
		this.taskList = taskList;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}
	
	private String checkTypeCode;
	
	private String checkBinCode;

	public String getCheckTypeCode() {
		return checkTypeCode;
	}

	public void setCheckTypeCode(String checkTypeCode) {
		this.checkTypeCode = checkTypeCode;
	}

	public String getCheckBinCode() {
		return checkBinCode;
	}

	public void setCheckBinCode(String checkBinCode) {
		this.checkBinCode = checkBinCode;
	}

	public Byte getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(Byte isSubmit) {
		this.isSubmit = isSubmit;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}
	
	
}
