package com.inossem.wms.vo.auth;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.ToDoReceiptVo", description="我的任务清单出参")
public class ToDoReceiptVo {
			
	@ApiModelProperty(value = "未完成数量")
	private Integer count;
	
	@ApiModelProperty(value = "单据类型")
	private Integer receiptType;
	
	@ApiModelProperty(value = "单据类型描述")
	private String receiptTypeName;
	
	@ApiModelProperty(value = "权限resourceName")
	private String resourceName;
	
	@ApiModelProperty(value = "权限resourceCode")
	private String resourcesCode;
	
	@ApiModelProperty(value = "代办url")
	private String url;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public String getReceiptTypeName() {
		return receiptTypeName;
	}

	public void setReceiptTypeName(String receiptTypeName) {
		this.receiptTypeName = receiptTypeName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourcesCode() {
		return resourcesCode;
	}

	public void setResourcesCode(String resourcesCode) {
		this.resourcesCode = resourcesCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	



}
