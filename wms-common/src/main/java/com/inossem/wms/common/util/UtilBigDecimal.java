package com.inossem.wms.common.util;

import java.math.BigDecimal;

import com.inossem.wms.constant.Const;

public class UtilBigDecimal {

	/**
	 * 除去尾随零
	 * 
	 * 
	 * @return
	 */
	public static BigDecimal getBigDecimalStripTrailingZeros(BigDecimal bigDecimal) {
		if (bigDecimal == null) {
			return BigDecimal.ZERO;
		} else {
			return bigDecimal.stripTrailingZeros();
		}
	}

	/**
	 * 除去尾随零,非科学计数法
	 * 
	 * 
	 * @return
	 */
	public static String getStringStripTrailingZeros(BigDecimal bigDecimal) {
		if (bigDecimal == null) {
			return "0";
		} else {
			return bigDecimal.stripTrailingZeros().toPlainString();
		}
	}

	/**
	 * 返回非空定点数字符串
	 * 
	 * 
	 * @return
	 */
	public static String getString(BigDecimal bigDecimal) {
		if (bigDecimal == null) {
			return Const.STRING_EMPTY;
		} else {
			return bigDecimal.toPlainString();
		}
	}

	/**
	 * 保留两位小数
	 * 
	 * 
	 * @return
	 */
	public static String getStringRetainDecimals(BigDecimal bigDecimal) {
		if (bigDecimal == null) {
			return "0";
		} else {
			return bigDecimal.setScale(2).toPlainString();
		}
	}

}
