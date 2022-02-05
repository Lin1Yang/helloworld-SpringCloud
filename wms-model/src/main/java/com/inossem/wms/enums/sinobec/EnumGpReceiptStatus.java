package com.inossem.wms.enums.sinobec;
/**
 * 功能描述: 〈匹配情况〉
 *
 * @return:
 * @since: 1.0.0
 * @Author: cxq
 * @Date: 2020/3/23 0023 18:03
 */
public enum EnumGpReceiptStatus {
	DEFAULT((byte) 0),
	/**
	 * 收货
	 */
	GR((byte) 1),
	/**
	 * 上架
	 */
	LOAD((byte) 2),
	/**
	 * 下架
	 */
	UNLOAD((byte) 3),
	/**
	 * 发货
	 */
	GI((byte)4);

	private Byte value;

	private EnumGpReceiptStatus(Byte value) {
		this.value = value;
	}

	public Byte getValue() {
		return this.value;
	}
}
