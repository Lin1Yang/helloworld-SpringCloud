package com.inossem.wms.enums.sinobec;
/**
 * 功能描述: 〈匹配情况〉
 *
 * @return:
 * @since: 1.0.0
 * @Author: cxq
 * @Date: 2020/3/23 0023 18:03
 */
public enum EnumBinOperationMode {
	/** 正常匹配 value=10 */
	NORMAL_MATCH((byte) 10),
	/** 库存数量大于订单数量 value=20 */
	STOCK_LARGE_ORDER((byte) 20),
	/** 库存数量小于订单数量 value=30 */
	STOCK_LESS_ORDER((byte) 30),
	/** 无法匹配 value=40 */
	CANNOT_MATCH((byte) 40);

	private Byte value;

	private EnumBinOperationMode(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return this.value;
	}
}
