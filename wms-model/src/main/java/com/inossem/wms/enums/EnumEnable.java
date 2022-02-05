package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumEnable {

	/** 启用 value=1 */
	ENABLE((byte)1),
	/** 不启用 value=0 */
	UNABLE((byte)0);
	
	private Byte value;

	public Byte getValue() {
		return value;
	}

	private EnumEnable(Byte value) {
		this.value = value;
	}
	
	private static Map<Byte, String> map;

	public static Map<Byte, String> toMap() {
		if (map == null) {
			EnumEnable[] ary = EnumEnable.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumEnable enumReceiptStatus : ary) {
				enumMap.put(enumReceiptStatus.getValue(), enumReceiptStatus.name());
			}
			map = enumMap;
		}
		return map;
	}

	public static String getEnumName(Byte value) {
		return toMap().get(value);
	}
	
}
