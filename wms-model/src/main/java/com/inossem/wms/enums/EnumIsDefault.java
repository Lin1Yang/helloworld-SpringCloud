package com.inossem.wms.enums;

/**
 * 对应数据库字段是否默认
 * @author libin
 * 2019年3月8日
 */
public enum EnumIsDefault {
	/** 非默认 value=0 */
	NON_DEFAULT((byte) 0),
	/** 默认的 value=1 */
	DEFAULT((byte) 1),
	;


	private Byte value;

	private EnumIsDefault(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return this.value;
	}
}
