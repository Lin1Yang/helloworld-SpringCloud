package com.inossem.wms.enums;

public enum EnumButtonFlag {
	// 差异重新盘点
	BUTTON_FLAG_RE_INVENTORY(1),
	// 仓位差异
	STOCK_TASK_BIN_DIFFERENCE(2),
	// 批次差异
	STOCK_TASK_BATCH_DIFFERENCE(3);


	/** 枚举值 */
	private Integer value;

	private EnumButtonFlag(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
