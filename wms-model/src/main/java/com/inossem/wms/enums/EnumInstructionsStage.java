package com.inossem.wms.enums;

public enum EnumInstructionsStage {


	/** 一阶段二阶段一起完成 */
	STAGE_ALL((byte) 0),
	/** 创建指令 */
	STAGE_ONE((byte) 1),
	/** 完成指令 */
	STAGE_TWO((byte) 2);
	
	
	/** 枚举值 */
	private Byte value;

	public Byte getValue() {
		return value;
	}

	private EnumInstructionsStage(Byte value) {
		this.value = value;
	}


	

}
