package com.inossem.wms.enums;

/**
 * 打印类型枚举
 * author: sw
 * date: 2019/1/23
 */
public enum EnumPrintType {

	ZPL((byte)0),

	PDF((byte)1);

	private Byte value;

	private EnumPrintType(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return this.value;
	}

	public void setValue(Byte value) {
		this.value = value;
	}

}
