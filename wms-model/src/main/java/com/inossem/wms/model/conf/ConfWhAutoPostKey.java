package com.inossem.wms.model.conf;

public class ConfWhAutoPostKey {
	private String whCode;

	private Integer receiptType;

	private int hash;

	public ConfWhAutoPostKey() {

	}

	public ConfWhAutoPostKey(String whCode, Integer receiptType) {
		this.whCode = whCode;
		this.receiptType = receiptType;
	}

	public String getWhCode() {
		return whCode;
	}

	public void setWhCode(String whCode) {
		this.whCode = whCode == null ? null : whCode.trim();
	}

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.whCode == null ? 0 : this.whCode.hashCode();

			h = 13131 * h + (this.receiptType == null ? 0 : this.receiptType.hashCode());

			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof ConfWhAutoPostKey) {
			ConfWhAutoPostKey another = (ConfWhAutoPostKey) obj;
			if (this.whCode == null || this.receiptType == null) {
				return false;
			} else if (this.whCode.equalsIgnoreCase(another.whCode) && this.receiptType.equals(another.receiptType)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
}