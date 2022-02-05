package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumStockTakeResult {

	STOCK_TAKE_RESULT_PROFIT((byte) 1), 
	STOCK_TAKE_RESULT_LOSS((byte) 2);
	
	/** 描述 */
	private byte name;

	private EnumStockTakeResult(byte name) {
		this.name = name;
	}

	public byte getName() {
		return name;
	}

	public void setName(byte name) {
		this.name = name;
	}
	
	private static Map<Byte, String> map;

	public static Map<Byte, String> toMap() {
		if (map == null) {
			EnumStockTakeResult[] ary = EnumStockTakeResult.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumStockTakeResult enumStockTakeResult : ary) {
				enumMap.put(enumStockTakeResult.getName(), enumStockTakeResult.name());
			}
			map = enumMap;
		}
		return map;
	}

	public static String getEnumName(Byte value) {
		return toMap().get(value);
	}
}
