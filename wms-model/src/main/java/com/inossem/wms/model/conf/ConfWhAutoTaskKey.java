package com.inossem.wms.model.conf;

public class ConfWhAutoTaskKey {
    private String whCode;

    private Integer receiptType;

    private Integer preReceiptType = 0;
    
    private int hash;

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

    public Integer getPreReceiptType() {
        return preReceiptType;
    }

    public void setPreReceiptType(Integer preReceiptType) {
        this.preReceiptType = preReceiptType;
    }
    
    @Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			h = this.whCode == null ? 0 : this.whCode.hashCode();

			h = 13131 * h + (this.receiptType == null ? 0 : this.receiptType.hashCode());

			h = 13131 * h + (this.preReceiptType == null ? 0 : this.preReceiptType.hashCode());
			
			hash = h;
		}
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof ConfWhAutoTaskKey) {
			ConfWhAutoTaskKey another = (ConfWhAutoTaskKey) obj;
			if (this.whCode == null || this.receiptType == null|| this.preReceiptType == null) {
				return false;
			} else if (this.whCode.equalsIgnoreCase(another.whCode) && this.receiptType.equals(another.receiptType)
					 && this.preReceiptType.equals(another.preReceiptType)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
    
    
}