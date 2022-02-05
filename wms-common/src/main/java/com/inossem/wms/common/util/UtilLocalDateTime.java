package com.inossem.wms.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import com.inossem.wms.constant.Const;

public class UtilLocalDateTime {

	/**
	 * 返回非空日期字符串
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return yyyy-MM-dd
	 */
	public static String getStringDateForLocalDateTime(LocalDateTime dateTime) {
		if (dateTime == null) {
			return Const.STRING_EMPTY;
		} else {
			return dateTime.format(Const.MATTER_DATE);
		}
	}

	/**
	 * 返回非空日期时间字符串
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDateTimeForLocalDateTime(LocalDateTime dateTime) {
		if (dateTime == null) {
			return Const.STRING_EMPTY;
		} else {
			return dateTime.format(Const.MATTER_DATETIME);
		}
	}

	/**
	 * 返回非空时间字符串
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return HH:mm:ss
	 */
	public static String getStringTimeForLocalDateTime(LocalDateTime dateTime) {
		if (dateTime == null) {
			return Const.STRING_EMPTY;
		} else {
			return dateTime.format(Const.MATTER_TIME);
		}
	}

	/**
	 * 得到系统当前日期时间
	 * 
	 * @return 当前日期时间
	 */
	public static LocalDateTime getNow() {
		return LocalDateTime.now();
	}
	
	/**
	 * LocalDateTime转Date
	 * 
	 * @return 当前日期时间
	 */
	public static Date getDate(LocalDateTime dateTime) {
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDateTime localDateTime = dateTime;
		ZonedDateTime zdt = localDateTime.atZone(zoneId);
		return Date.from(zdt.toInstant());
	}
}
