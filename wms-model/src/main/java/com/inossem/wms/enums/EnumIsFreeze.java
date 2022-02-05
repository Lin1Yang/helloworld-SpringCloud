package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumIsFreeze {
	

	//状态是不是被冻结
	UN_FREEZE((byte)0), //非冻结
	IS_FREEZE((byte)1),	//已冻结
	;
	
	private static Map<Byte, String> map;

	public static Map<Byte, String> toMap() {
		if (map == null) {
			EnumIsFreeze[] ary = EnumIsFreeze.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumIsFreeze enumIsFreeze : ary) {
				enumMap.put(enumIsFreeze.getValue(), enumIsFreeze.name());
			}
			map = enumMap;
		}
		return map;
	}

	/** 枚举值 */
	private Byte value;

	private EnumIsFreeze(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return value;
	}

	public void setValue(Byte value) {
		this.value = value;
	}

	public static String getEnumName(Byte value) {
		return toMap().get(value);
	}
}
