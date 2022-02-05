package com.inossem.wms.enums;

public enum EnumReceiptTreeType {
	/** 未知 value=0 */
	UNKNOWN((byte) 0),
	/** 自低向上 value=1 */
	BOTTOM_UP((byte) 1),
	/** 自顶向下 value=2 */
	TOP_DOWN((byte) 2),;

	private Byte value;

	private EnumReceiptTreeType(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return this.value;
	}
}
