package com.inossem.wms.enums;

public enum EnumIsDelete {
	/** 未删除 value=0 */
	UN_DELETE((byte) 0),
	/** 已删除 value=1 */
	IS_DELETE((byte) 1),
	;


	private Byte value;

	private EnumIsDelete(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return this.value;
	}
}
