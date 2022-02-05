package com.inossem.wms.enums;

public enum EnumNum {

	ZERO((byte)0),
	ONE((byte)1),
	TWO((byte)2),
	THREE((byte)3);
	
	private Byte value;

	public Byte getValue() {
		return value;
	}

	private EnumNum(Byte value) {
		this.value = value;
	}
	
}
