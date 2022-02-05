package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumUserType {
	
	
	INSIDE_SYSUSER((byte)10), //内部用户
	OUTSIDE_SUPPLIER_USER((byte)20), //外部供应商用户
	OUTSIDE_CUSTOMER_USER((byte)30), //外部客户用户
	OUTSIDE_BUSINESS_USER((byte)40), //外部业务用户
	INTERFACE_USER((byte)50), //接口用户
	;
	

	private static Map<Byte, String> map;

	public static Map<Byte, String> toMap() {
		if (map == null) {
			EnumUserType[] ary = EnumUserType.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumUserType enumUserType : ary) {
				enumMap.put(enumUserType.getValue(), enumUserType.name());
			}
			map = enumMap;
		}
		return map;
	}

	/** 枚举值 */
	private Byte value;

	private EnumUserType(Byte value) {
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
