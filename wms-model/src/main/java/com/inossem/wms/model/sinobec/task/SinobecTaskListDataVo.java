package com.inossem.wms.model.sinobec.task;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel(value="com.inossem.wms.model.sinobec.task.SinobecTaskListDataVo",description="作业单列表出参对象")
public class SinobecTaskListDataVo {

	
	private List<SinobecTaskVo> taskList;
	
	private String receiptCode;
	
	private String createUserName;
	
	private Integer totalCount;
	
	private Byte receiptStatusName;

	public List<SinobecTaskVo> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<SinobecTaskVo> taskList) {
		this.taskList = taskList;
	}
	
	

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Byte getReceiptStatusName() {
		return receiptStatusName;
	}

	public void setReceiptStatusName(Byte receiptStatusName) {
		this.receiptStatusName = receiptStatusName;
	}
	
	
}
