package com.inossem.wms.common.util;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.inossem.wms.constant.Const;

public class UtilLocalDate {
	/**
	 * 返回非空日期字符串
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return yyyy-MM-dd
	 */
	public static String getStringDateForLocalDate(LocalDate date) {
		if (date == null) {
			return Const.STRING_EMPTY;
		} else {
			return date.format(Const.MATTER_DATE);
		}
	}

	public static boolean checkLocalDate(@NotNull LocalDate param, @Nullable LocalDate beginDateTime,
			@Nullable LocalDate endDateTime) {
		if (beginDateTime == null) {
			if (endDateTime == null) {
				return true;
			} else {
				if (param.isAfter(endDateTime)) {
					return false;
				} else {
					return true;
				}
			}
		} else {
			if (param.isBefore(beginDateTime)) {
				return false;
			} else if (endDateTime == null) {
				return true;
			} else if (param.isAfter(endDateTime)) {
				return false;
			} else {
				return true;
			}
		}

	}
}
