package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumIsLocked {
	
	//状态是不是被锁定
	UN_LOCKED((byte)0), //未锁定
	IS_LOCKED( (byte)1),//已锁定
	;
	
	private static Map<Byte, String> map;

	public static Map<Byte, String> toMap() {
		if (map == null) {
			EnumIsLocked[] ary = EnumIsLocked.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumIsLocked enumIsLocked : ary) {
				enumMap.put(enumIsLocked.getValue(), enumIsLocked.name());
			}
			map = enumMap;
		}
		return map;
	}

	/** 枚举值 */
	private Byte value;

	private EnumIsLocked(Byte value) {
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
