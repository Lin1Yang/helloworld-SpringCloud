package com.inossem.wms.enums;

public enum EnumBinOperationMode {
	/** 不启用 value=0 */
	BIN_OPERATION_UNABLE((byte) 0),
	/** 先过账后作业 value=10 */
	BIN_OPERATION_MODE_POST_FIRST((byte) 10),
	/** 先作业后过账 value=20 */
	BIN_OPERATION_MODE_TASK_FIRST((byte) 20),
	/** 同时过账作业 value=30 */
	BIN_OPERATION_MODE_SAME_TIME((byte) 30);

	private Byte value;

	private EnumBinOperationMode(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return this.value;
	}
}
