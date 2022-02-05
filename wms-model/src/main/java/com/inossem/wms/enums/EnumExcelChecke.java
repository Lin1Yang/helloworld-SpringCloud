package com.inossem.wms.enums;

/**
 * 文件导入校验规则定义
 * @author ty
 *
 */
public enum EnumExcelChecke {
	
	// 非空验证
	CHECK_NULL("check_null"),
	
	// 重复验证
	CHECK_REPEAT("check_repeat"),
	
	// 转换值验证
	CHANGE_VALUE("change_value"),
	
	// 区间验证
	OPERATOR("operator"),
	
	// 验证结果集里必须包含
	INCLUDE_IN("include_in"),
	
	// 验证结果集里不包含
	INCLUDE_OUT("include_out");
	
	
	private String value;

	private EnumExcelChecke(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

}
