package com.inossem.wms.model.rel;

import com.inossem.wms.common.ReceiptRidKey;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.model.rel.RelReceiptRidKey", description = "单据行关系表")
public class RelReceiptRidKey extends ReceiptRidKey {
	@ApiModelProperty(value = "前续单据类型")
	private Integer preReceiptType;

	@ApiModelProperty(value = "前续单据编号")
	private String preReceiptCode;

	@ApiModelProperty(value = "前续单据行项目")
	private String preReceiptRid;

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
		this.receiptCode = receiptCode == null ? null : receiptCode.trim();
	}

	public String getReceiptRid() {
		return receiptRid;
	}

	public void setReceiptRid(String receiptRid) {
		this.receiptRid = receiptRid == null ? null : receiptRid.trim();
	}

	public Integer getPreReceiptType() {
		return preReceiptType;
	}

	public void setPreReceiptType(Integer preReceiptType) {
		this.preReceiptType = preReceiptType;
	}

	public String getPreReceiptCode() {
		return preReceiptCode;
	}

	public void setPreReceiptCode(String preReceiptCode) {
		this.preReceiptCode = preReceiptCode == null ? null : preReceiptCode.trim();
	}

	public String getPreReceiptRid() {
		return preReceiptRid;
	}

	public void setPreReceiptRid(String preReceiptRid) {
		this.preReceiptRid = preReceiptRid == null ? null : preReceiptRid.trim();
	}
}