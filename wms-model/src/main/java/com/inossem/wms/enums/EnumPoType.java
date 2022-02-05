package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumPoType {
	

	
	/******************sinobec*********************************/
	SINOBEC_INPUT_PURCHASE(1),
	SINOBEC_INPUT_TRANSFER_IN(2),
	SINOBEC_INPUT_ADJUSTMENT_IN(3),
	SINOBEC_INPUT_RETURN(4),
	/******************sinobec*********************************/
	;

	private static Map<Integer, String> map;

	public static Map<Integer, String> toMap() {
		if (map == null) {
			EnumPoType[] ary = EnumPoType.values();
			Map<Integer, String> enumMap = new HashMap<Integer, String>();
			for (EnumPoType EnumPoType : ary) {
				enumMap.put(EnumPoType.getValue(), EnumPoType.name());
			}
			map = enumMap;
		}
		return map;
	}

	/** 枚举值 */
	private Integer value;

	private EnumPoType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public static String getEnumName(Integer value) {
		return toMap().get(value);
	}

}
