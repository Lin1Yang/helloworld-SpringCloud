package com.inossem.wms.enums;

public enum EnumInputAbilityInspect {
	INPUT_ABILITY_INSPECT_NO_INSPECTION("0", "没有检查能力"), 
	INPUT_ABILITY_INSPECT_BIN_MAX_WEIGHT_INSPECTION("1", "根据仓位最大重量检验"), 
	INPUT_ABILITY_INSPECT_TYPE_MAX_WEIGHT_INSPECTION("2", "根据仓储单元最大重量检验"), 
	INPUT_ABILITY_INSPECT_BIN_MAX_VOLUME_INSPECTION("3", "根据仓位最大体积检验"), 
	INPUT_ABILITY_INSPECT_TYPE_MAX_VOLUME_INSPECTION("4", "根据仓储单元最大体积检验");
	
	/** 描述 */
	private String name;
	/** 枚举值 */
	private String value;

	private EnumInputAbilityInspect(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
