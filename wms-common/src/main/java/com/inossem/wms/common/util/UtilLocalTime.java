package com.inossem.wms.common.util;

import java.time.LocalTime;

import com.inossem.wms.constant.Const;

public class UtilLocalTime {

	/**
	 * 返回非空时间字符串
	 * 
	 * @param time
	 *            时间
	 * @return yyyy-MM-dd
	 */
	public static String getStringTimeForLocalTime(LocalTime time) {
		if (time == null) {
			return Const.STRING_EMPTY;
		} else {
			return time.format(Const.MATTER_TIME);
		}
	}
}
