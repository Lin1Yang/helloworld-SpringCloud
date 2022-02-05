package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumStockStatus {

	STOCK_STATUS_BUY_SELL((byte)10, "Buy&SELL"), 
	STOCK_STATUS_SCRAP((byte)20, "Scrap"), 
	STOCK_STATUS_RETURN((byte)30, "Return"),
	STOCK_STATUS_SAMPLE((byte)30, "Sample"),
	STOCK_STATUS_DAMAGED((byte)30, "Damaged"),
	
	;
	
	/** 描述 */
	private byte name;
	/** 枚举值 */
	private String value;

	private EnumStockStatus(byte name, String value) {
		this.name = name;
		this.value = value;
	}
	private static Map<Object, String> map;

	private static Map<Object, String> toMap() {
		if (map == null) {
			EnumStockStatus[] ary = EnumStockStatus.values();
			Map<Object, String> tempMap = new HashMap<>();
			for (EnumStockStatus o : ary) {
				tempMap.put(o.getName(), o.getValue());
			}
			map = tempMap;
		}
		return map;
	}

	public static String getNameByValue(byte value){
		return toMap().get(value);
	}

	public byte getName() {
		return name;
	}

	public void setName(byte name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
