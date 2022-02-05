package com.inossem.wms.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.common.ReceiptRid", description = "单据表")
public class ReceiptKey {
	@ApiModelProperty(value = "单据类型")
	protected Integer receiptType;
	@ApiModelProperty(value = "单据编号")
	protected String receiptCode;

	protected int hash;

	public ReceiptKey() {
	}

	public ReceiptKey(Integer receiptType, String receiptCode) {
		this.receiptType = receiptType;
		this.receiptCode = receiptCode;
	}

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

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.receiptType == null ? 0 : this.receiptType.hashCode();

			h = 13131 * h + (this.receiptCode == null ? 0 : this.receiptCode.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof ReceiptKey) {
			ReceiptKey another = (ReceiptKey) obj;
			if (this.receiptType == null || this.receiptCode == null) {
				return false;
			} else if (this.receiptType.equals(another.receiptType)
					&& this.receiptCode.equalsIgnoreCase(another.receiptCode)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
}
