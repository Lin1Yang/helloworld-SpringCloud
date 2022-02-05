package com.inossem.wms.enums;

public enum EnumDebitCredit {
	/** 借贷标识，借S，代表增加(德语soll借方的缩写) */
	DEBIT_S_ADD("S"), 
	/** 借贷标识，贷H，代表扣减(德语haben贷方的缩写) */
	CREDIT_H_SUBTRACT("H");

	/** 描述 */
	private String value;

	private EnumDebitCredit(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
