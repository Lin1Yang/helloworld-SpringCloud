package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 单据日志状态的枚举类
 */
public enum EnumReceiptOperationType {
	/**
	 * 创建 10
	 */
	RECEIPT_OPERATION_ESTABLISH((byte)10),
	/**
	 * 修改 20
	 */
	RECEIPT_OPERATION_SAVE((byte)20),
	/**
	 * 提交 30
	 */
	RECEIPT_OPERATION_SUBMIT((byte)30),
	/**
	 * 发起审批 31
	 */
	RECEIPT_OPERATION_START_APPROVAL((byte)31),
	/**
	 * 审批驳回 32
	 */
	RECEIPT_OPERATION_REJECT_APPROVAL((byte)32),
	/**
	 * 审批通过 33
	 */
	RECEIPT_OPERATION_PASS_APPROVAL((byte)33),
	/**
	 * 过账 40
	 */
	RECEIPT_OPERATION_POSTING((byte)40),	
	/**
	 * 自动过账 41
	 */
	RECEIPT_OPERATION_AUTO_POSTING((byte)41),
	/**
	 * 冲销 50
	 */
	RECEIPT_OPERATION_WRITEOFF((byte)50),
	/**
	 * 删除 60
	 */
	RECEIPT_OPERATION_DELETE((byte)60),
	/**
	 * 核销 70
	 */
	RECEIPT_OPERATION_DEBT_OFFSET((byte)70),
	/**
	 * 往前 80
	 */
	RECEIPT_OPERATION_FORWARD((byte)80),
	/**
	 * 调整仓位
	 */
	RECEIPT_OPERATION_CHANGE_BIN((byte)81),
	/**
	 * 完成 90
	 */
	RECEIPT_OPERATION_COMPLATE((byte)90),
	;

	/** 枚举值 */
	private Byte value;

	private EnumReceiptOperationType(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return value;
	}

	public void setValue(Byte value) {
		this.value = value;
	}
	
	private static Map<Byte, String> map;

	public static Map<Byte, String> toMap() {
		if (map == null) {
			EnumReceiptOperationType[] ary = EnumReceiptOperationType.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumReceiptOperationType enumObj : ary) {
				enumMap.put(enumObj.getValue(), enumObj.name());
			}
			map = enumMap;
		}
		return map;
	}
	
	public static String getEnumName(Byte value) {
		return toMap().get(value);
	}

}
