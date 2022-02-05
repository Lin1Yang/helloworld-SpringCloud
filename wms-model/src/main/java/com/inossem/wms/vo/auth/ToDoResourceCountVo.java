package com.inossem.wms.vo.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="com.inossem.wms.vo.auth.ToDoRecourceCountVo", description="待办事项数量")
public class ToDoResourceCountVo {
	
	
	@ApiModelProperty(value = "代办事项名称")
	private String resourceName;
	
	@ApiModelProperty(value = "代办resourceid")
	private String resourcesCode;
	
	@ApiModelProperty(value = "代办url")
	private String url;
	
	@ApiModelProperty(value = "各个代办数量")
	private int count;
	
	@ApiModelProperty(value = "对应业务单据类型")
	private Integer receiptType;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}
    
    

  
}