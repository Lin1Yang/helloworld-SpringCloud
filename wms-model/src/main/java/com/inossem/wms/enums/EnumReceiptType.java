package com.inossem.wms.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumReceiptType {
	

	
	/******************sinobec*********************************/
	SINOBEC_INPUT_PURCHASE(101),
	SINOBEC_INPUT_CUSTOMER_RETURN(102),
	SINOBEC_INPUT_TRANSFER_IN(103),
	SINOBEC_INPUT_ADJUSTMENT_IN(104),
	SINOBEC_INPUT_MASK_IN(105),
	SINOBEC_INPUT_MASK_RETURN(106),

	//销售出库
	SINOBEC_OUTPUT_SALE(201),
	//转出
	SINOBEC_OUTPUT_TRANSFER_OUT(202),
	//委外加工转出
	SINOBEC_OUTPUT_COMMISSIONED_PROCESSING(203),
	SINOBEC_OUTPUT_VENDOR_RETURN(204),
	//口罩
	SINOBEC_OUTPUT_MASK_OUT(205),
	
	
	SINOBEC_TASK_PUT_AWAY(301),
	SINOBEC_TASK_PICK(302),
	SINOBEC_TASK_ARRANGE(303),
	SINOBEC_STOCK_TAKE_BIN_ARRANGE(304),
	
	SINOBEC_STOCK_TAKE(400),
	
	/******************sinobec*********************************/
	;

	private static Map<Integer, String> map;

	public static Map<Integer, String> toMap() {
		if (map == null) {
			EnumReceiptType[] ary = EnumReceiptType.values();
			Map<Integer, String> enumMap = new HashMap<Integer, String>();
			for (EnumReceiptType enumReceiptType : ary) {
				enumMap.put(enumReceiptType.getValue(), enumReceiptType.name());
			}
			map = enumMap;
		}
		return map;
	}

	/** 枚举值 */
	private Integer value;

	private EnumReceiptType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public static String getEnumName(Integer value) {
		return toMap().get(value);
	}

}
