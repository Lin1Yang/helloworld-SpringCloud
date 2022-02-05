package com.inossem.wms.enums;



public enum EnumFreezeType {
	/** 未冻结 */
	FREEZE_NON((byte) 0),
	/** 存储单元主数据手动冻结 */
	FREEZE_DIC_CELL((byte) 1),
	/** 存储单元WCS冻结 */
	FREEZE_WCS_CELL((byte) 2),
	/** 仓位WCS冻结 */
	FREEZE_WCS_BIN((byte) 3),
	/** 仓位主数据手动冻结 */
	FREEZE_DIC_BIN((byte) 2),
	/** 仓位盘点冻结 */
	FREEZE_TAKE_CELL((byte) 1);
	
	/** 枚举值 */
	private Byte value;

	public Byte getValue() {
		return value;
	}

	private EnumFreezeType(Byte value) {
		this.value = value;
	}

}
