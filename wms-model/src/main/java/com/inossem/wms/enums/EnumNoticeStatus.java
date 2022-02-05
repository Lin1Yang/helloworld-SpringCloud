package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 公告状态的枚举类
 */

public enum EnumNoticeStatus {
	
	/**
	 * 未发布 0
	 */
	NOTICE_STATUS_UNPUBLISHED((byte)0),
	/**
	 * 已发布 1
	 */
	NOTICE_STATUS_PUBLISHED((byte)1);
	
	/** 枚举值 */
	private Byte value;

	private EnumNoticeStatus(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return value;
	}

	public void setValue(Byte value) {
		this.value = value;
	}

	private static Map<Byte, String> map;

	public static Map<Byte, String> toMap() {
		if (map == null) {
			EnumNoticeStatus[] ary = EnumNoticeStatus.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumNoticeStatus EnumNoticeStatus : ary) {
				enumMap.put(EnumNoticeStatus.getValue(), EnumNoticeStatus.name());
			}
			map = enumMap;
		}
		return map;
	}

	public static String getEnumName(Byte value) {
		return toMap().get(value);
	}

}
