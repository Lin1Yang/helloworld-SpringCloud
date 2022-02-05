package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumReceiptStatus {
	/** 创建 value=1 */
	RECEIPT_STATUS_CREATE((byte)1),
	/** 已驳回 value=5 */
	RECEIPT_STATUS_REJECTED((byte)5),
	/** 草稿 value=10 */
	RECEIPT_STATUS_DRAFT((byte) 10),
	/** 审批中 value=15 */
	RECEIPT_STATUS_APPROVING((byte) 15),
	/** 已提交 value=20 */
	RECEIPT_STATUS_SUBMITTED((byte) 20),
	/** 已发货 value=21 */
	RECEIPT_STATUS_DELIVERIED((byte) 21),
	/** 已验收 value=23 */
	RECEIPT_STATUS_INSPECTED((byte) 23),
	/** 已入库 value=25 */
	RECEIPT_STATUS_INPUTED((byte) 25),	
	/** 待提货 value=26 */
	RECEIPT_STATUS_PENDING_TAKE_DELIVERY((byte) 26),
	/** 已出库 value=29 */
	RECEIPT_STATUS_OUTPUTED((byte) 29),
	/** 待核销 value=30 */
	RECEIPT_STATUS_PENDING_DEBT_OFFSET((byte) 30),	
	/** 未记账 value=35 */
	RECEIPT_STATUS_UN_POSTED((byte) 35),
	/** 已记账 value=40 */
	RECEIPT_STATUS_POSTED((byte) 40),
	/** 待计数 value=45 */
	RECEIPT_STATUS_UN_COUNTED((byte) 45),
	/** 已计数 value=50 */
	RECEIPT_STATUS_COUNTED((byte) 50),
	/** 已仓位差异处理 value=52 */
	RECEIPT_STATUS_FLAT_DIFF_BIN((byte) 52),
	/** 已批次差异处理 value=54 */
	RECEIPT_STATUS_FLAT_DIFF_BATCH((byte) 54),
	/** 未作业 value=58 */
	RECEIPT_STATUS_UN_TASK((byte) 58),
	/** 作业中 value=59 */
	RECEIPT_STATUS_IN_TASK((byte) 59),
	/** 已作业 value=60 */
	RECEIPT_STATUS_TASK((byte) 60),
	/** 未同步 value=70 */
	RECEIPT_STATUS_UNSYNC((byte) 70),
	/** 核销中 value=80 */
	RECEIPT_STATUS_DOING_DEBT_OFFSET((byte) 80),	
	/** 未完成 value=85 */
	RECEIPT_STATUS_UN_COMPLETED((byte) 85),
	/** 已完成 value=90 */
	RECEIPT_STATUS_COMPLETED((byte) 90),
	/** 冲销中 value=100 */
	RECEIPT_STATUS_WRITING_OFF((byte) 100),
	/** 已冲销 value=110 */
	RECEIPT_STATUS_WRITED_OFF((byte) 110),
	// 已删除【废弃】
	//RECEIPT_STATUS_DELETED((byte) 120),
	/** 已关闭 value=127 */
	RECEIPT_STATUS_CLOSED((byte) 127),;

	/** 枚举值 */
	private Byte value;

	private EnumReceiptStatus(Byte value) {
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
			EnumReceiptStatus[] ary = EnumReceiptStatus.values();
			Map<Byte, String> enumMap = new HashMap<Byte, String>();
			for (EnumReceiptStatus enumReceiptStatus : ary) {
				enumMap.put(enumReceiptStatus.getValue(), enumReceiptStatus.name());
			}
			map = enumMap;
		}
		return map;
	}

	public static String getEnumName(Byte value) {
		return toMap().get(value);
	}
}
