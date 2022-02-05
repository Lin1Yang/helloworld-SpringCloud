package com.inossem.wms.enums;

public enum EnumConfWhCode {
	// 不启用临时
	ENUM_CONF_WH_CODE_UNREAL("unreal"),
	// 入库临时
	ENUM_CONF_WH_CODE_INPUT("input"),
	// 组盘临时
	ENUM_CONF_WH_CODE_SETUP_CELL("setup_cell"),
	// 拣配临时
	ENUM_CONF_WH_CODE_PICKING("picking"),
	// 出库临时
	ENUM_CONF_WH_CODE_OUTPUT("output"),
	// 转储临时
	ENUM_CONF_WH_CODE_TRANSPORT("transport"),
	// 入库退库临时
	ENUM_CONF_WH_CODE_INPUT_RETURN("input_return"),
	// 盘点临时
	ENUM_CONF_WH_CODE_STOCKTAKE("stocktake"),
	// 冲销临时
	ENUM_CONF_WH_CODE_WRITE_OFF("write_off"),
	// 出库退库临时
	ENUM_CONF_WH_CODE_OUTPUT_RETURN("output_return"),
	// WCS上架临时区
	ENUM_CONF_WH_CODE_WCS_LOAD("wcs_load"),
	// WCS下架临时区
	ENUM_CONF_WH_CODE_WCS_UN_LOAD("wcs_un_load"),
	
	// 仓库号
	ENUM_CONF_WH_CODE("wh_code"),
	;

	/** 枚举值 */
	private String code;

	private EnumConfWhCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
