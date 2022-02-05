package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumIsSys {

	//是不是单点登录用户或者是不是统一认证
	UN_SYS((byte)0), //否
	IS_SYS((byte)1), //是
	;

	private static Map<Byte, String> map;

	public static Map<Byte, String> toMap() {
		if (map == null) {
			EnumIsSys[] ary = EnumIsSys.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumIsSys enumIsSys : ary) {
				enumMap.put(enumIsSys.getValue(), enumIsSys.name());
			}
			map = enumMap;
		}
		return map;
	}

	/** 枚举值 */
	private Byte value;

	private EnumIsSys(Byte value) {
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
