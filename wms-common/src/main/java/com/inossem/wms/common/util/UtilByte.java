package com.inossem.wms.common.util;

import com.inossem.wms.constant.Const;

public class UtilByte {

	/**
	 * 返回空定点数字符串
	 * 
	 * @param Byte
	 * @return
	 */
	public static String getStringOrNull(Byte b) {
		if (b == null) {
			return null;
		} else {
			return b.toString();
		}
	}

	/**
	 * 返回空字符串
	 * 
	 * @param Byte
	 * @return
	 */
	public static String getStringOrEmpty(Byte b) {
		if (b == null) {
			return Const.STRING_EMPTY;
		} else {
			return b.toString();
		}
	}
}
