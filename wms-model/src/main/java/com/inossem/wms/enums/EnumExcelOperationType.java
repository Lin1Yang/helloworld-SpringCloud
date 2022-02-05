package com.inossem.wms.enums;

/**
 * 文件导入导出操作类型
 * @author ty
 *
 */
public enum EnumExcelOperationType {
	
	// "用户信息表"
	EXCEL_USERS("excel_users");

	private String value;

	private EnumExcelOperationType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
