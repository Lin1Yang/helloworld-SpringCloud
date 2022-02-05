package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumStockTakeType {

	STOCK_TAKE_TYPE_DYNAMIC((byte) 1), 
	STOCK_TAKE_TYPE_CYCLE((byte) 2);
	
	/** 描述 */
	private byte name;

	private EnumStockTakeType(byte name) {
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
			EnumStockTakeType[] ary = EnumStockTakeType.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumStockTakeType enumStockTakeType : ary) {
				enumMap.put(enumStockTakeType.getName(), enumStockTakeType.name());
			}
			map = enumMap;
		}
		return map;
	}

	public static String getEnumName(Byte value) {
		return toMap().get(value);
	}
}
