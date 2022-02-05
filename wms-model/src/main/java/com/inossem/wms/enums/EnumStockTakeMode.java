package com.inossem.wms.enums;

public enum EnumStockTakeMode {

	STOCK_TAKE_MODE_BRIGHT((byte) 1), 
	STOCK_TAKE_MODE_BLIND((byte) 2);
	
	/** 描述 */
	private byte name;


	private EnumStockTakeMode(byte name) {
		this.name = name;
	}

	public byte getName() {
		return name;
	}

	public void setName(byte name) {
		this.name = name;
	}
	
	
}
