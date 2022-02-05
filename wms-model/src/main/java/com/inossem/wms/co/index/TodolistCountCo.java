package com.inossem.wms.co.index;

import java.util.Date;


public class TodolistCountCo {

	/**
	 * 是否库存地点筛选
	 */
	private Boolean locationAuthority;
	
	private String resourcesCode;
	
	private Integer currentUserId;
	
	private Integer createUserId;
	
	private String todolistReceiptStatus;
	
	private Date startTime;
	
	private Date endTime;

	public Boolean getLocationAuthority() {
		return locationAuthority;
	}

	public void setLocationAuthority(Boolean locationAuthority) {
		this.locationAuthority = locationAuthority;
	}

	public String getResourcesCode() {
		return resourcesCode;
	}

	public void setResourcesCode(String resourcesCode) {
		this.resourcesCode = resourcesCode;
	}

	public Integer getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getTodolistReceiptStatus() {
		return todolistReceiptStatus;
	}

	public void setTodolistReceiptStatus(String todolistReceiptStatus) {
		this.todolistReceiptStatus = todolistReceiptStatus;
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
	
}
