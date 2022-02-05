package com.inossem.wms.co.auth;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.co.auth.ToDoReceiptListCo", description="我的任务清单入参")
public class ToDoReceiptListCo {
	
	@ApiModelProperty(value="开始时间", name="startTime", example="2018-11-30")
	private Date startTime;
	
	@ApiModelProperty(value="结束时间", name="endTime", example="2018-12-30")
	private Date endTime;

	@ApiModelProperty(value = "web端调用还是pad端",example="pad 1  web 0")
	private Byte resourcesType;
		
	@ApiModelProperty(value="创建人ID", name="createUserId", example="")
	private Integer createUserId;
	
	@ApiModelProperty(value="当前登陆人ID", name="currentUserId", example="")
	private Integer currentUserId;

	@ApiModelProperty(value = "前置单据类型集合",example="")
	protected List<Integer> receiptTypeList;

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

	public Byte getResourcesType() {
		return resourcesType;
	}

	public void setResourcesType(Byte resourcesType) {
		this.resourcesType = resourcesType;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}

	public List<Integer> getReceiptTypeList() {
		return receiptTypeList;
	}

	public void setReceiptTypeList(List<Integer> receiptTypeList) {
		this.receiptTypeList = receiptTypeList;
	}
	
	
	
	
	
}
