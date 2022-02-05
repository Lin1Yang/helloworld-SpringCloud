package com.inossem.wms.enums;

public enum EnumSequenceCode {
	
	SEQUENCE_BATCH("batch"),
	SEQUENCE_INPUT("input"), 
	SEQUENCE_OUTPUT("output"), 
	SEQUENCE_TRANSPORT("transport"), 
	SEQUENCE_RETURN("return"),
	SEQUENCE_DOC("doc"),
	SEQUENCE_DELIVERY("delivery"),
	SEQUENCE_INSPECT("inspect"),
	SEQUENCE_TASK_REQ("task_req"),
	SEQUENCE_TAKE("take"),
	SEQUENCE_TASK("task"),
	SEQUENCE_FREEZE_REASON("freeze_reason"),
	SEQUENCE_DELIVERY_CONSIGNEE("delivery_consignee"),
	SEQUENCE_MAT("mat"),
	SEQUENCE_TEXT("text"),
	SEQUENCE_HASTE("haste"),
	SEQUENCE_INSTRUCTIONS("instructions"),
	SEQUENCE_SERIAL_NUMBER("serial_number");

	private String value;

	public String getValue() {
		return value;
	}

	private EnumSequenceCode(String value) {
		this.value = value;
	}
	


}
