package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumOutputOrder {
	OUTPUT_ORDER_OUT_OF_SHELF((byte)10, "D-先出库后下架"), 
	OUTPUT_ORDER_SELF_OUT((byte)20, "E-先下架后出库"), 
	OUTPUT_ORDER_OFF_SHELVES((byte)30, "F-同时出库下架");
	
	/** 描述 */
	private byte name;
	/** 枚举值 */
	private String value;

	private EnumOutputOrder(byte name, String value) {
		this.name = name;
		this.value = value;
	}
	private static Map<Object, String> map;

	private static Map<Object, String> toMap() {
		if (map == null) {
			EnumOutputOrder[] ary = EnumOutputOrder.values();
			Map<Object, String> tempMap = new HashMap<>();
			for (EnumOutputOrder o : ary) {
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
