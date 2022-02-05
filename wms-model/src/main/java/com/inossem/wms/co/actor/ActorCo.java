package com.inossem.wms.co.actor;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 经办人映射类
 */
@ApiModel(value = "com.inossem.wms.co.actor.ActorCo",description = "经办人映射类")
public class ActorCo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(name="receiptType",value="单据类型")
	private Integer receiptType;

	@ApiModelProperty(name="receiptCode",value="单据code")
	private String receiptCode;
	
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

}
