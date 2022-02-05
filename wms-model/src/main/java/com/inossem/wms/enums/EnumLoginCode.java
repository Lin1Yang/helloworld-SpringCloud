package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumLoginCode {
	/** 登录成功*/
	LOGIN_SUCCESS("0"),
	/** 登录失败，用户名或密码错误 */
	LOGIN_ERROR_USER_NAME_PASS_WORD_WRONG("-1"),
	/** 登录失败，该用户已被冻结 */
	LOGIN_ERROR_USER_FROZEN("-2"),
	/** 用户账户有效期已到期 value=-3 */
	LOGIN_ERROR_USER_VALIDITY_EXPIRED_EXCEPTION("-3")
	;

	/** 枚举值 */
	private String value;

	private EnumLoginCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	private static Map<String, String> map;

	public static Map<String, String> toMap() {
		if (map == null) {
			EnumLoginCode[] ary = EnumLoginCode.values();
			Map<String, String> enumMap = new HashMap<String, String>();
			for (EnumLoginCode enumIsFreeze : ary) {
				enumMap.put(enumIsFreeze.getValue(), enumIsFreeze.name());
			}
			map = enumMap;
		}
		return map;
	}
	
	public static String getEnumName(String value) {
		return toMap().get(value);
	}
	
}
