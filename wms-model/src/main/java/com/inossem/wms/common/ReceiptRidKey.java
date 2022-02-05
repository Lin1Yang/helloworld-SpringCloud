package com.inossem.wms.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.inossem.wms.common.ReceiptRidKey", description = "单据行表")
public class ReceiptRidKey extends ReceiptKey {
	@ApiModelProperty(value = "单据行项目")
	protected String receiptRid;

	public ReceiptRidKey() {
	}

	public ReceiptRidKey(Integer receiptType, String receiptCode, String receiptRid) {
		this.receiptType = receiptType;
		this.receiptCode = receiptCode;
		this.receiptRid = receiptRid;
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

	public String getReceiptRid() {
		return receiptRid;
	}

	public void setReceiptRid(String receiptRid) {
		this.receiptRid = receiptRid;
	}

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.receiptType == null ? 0 : this.receiptType.hashCode();

			h = 13131 * h + (this.receiptCode == null ? 0 : this.receiptCode.hashCode());

			h = 13131 * h + (this.receiptRid == null ? 0 : this.receiptRid.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj!=null && ReceiptRidKey.class.isAssignableFrom(obj.getClass())) {
			ReceiptRidKey another = (ReceiptRidKey) obj;
			if (this.receiptType == null || this.receiptCode == null || this.receiptRid == null) {
				return false;
			} else if (this.receiptType.equals(another.receiptType)
					&& this.receiptCode.equalsIgnoreCase(another.receiptCode)
					&& this.receiptRid.equalsIgnoreCase(another.receiptRid)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
}
