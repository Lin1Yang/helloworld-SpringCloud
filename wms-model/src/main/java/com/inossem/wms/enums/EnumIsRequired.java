package com.inossem.wms.enums;

/**
 * 对应数据库字段是否必填
 * @author libin
 * 2019年3月9日
 */
public enum EnumIsRequired {
	/** 非必填 value=0 */
	NOT_REQUIRED((byte) 0),
	/** 必填的 value=1 */
	REQUIRED((byte) 1),
	;


	private Byte value;

	private EnumIsRequired(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return this.value;
	}
}
