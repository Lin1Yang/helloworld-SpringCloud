package com.inossem.wms.enums;

public enum EnumLang {
	enUS("en-US"), zhCN("zh-CN");
	/** 枚举值 */
	private String value;

	public String getValue() {
		return value;
	}

	private EnumLang(String value) {
		this.value = value;
	}

}
