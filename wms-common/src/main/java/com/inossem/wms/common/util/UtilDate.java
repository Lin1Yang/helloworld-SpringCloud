package com.inossem.wms.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.inossem.wms.constant.Const;

public class UtilDate {
	
	/**
	 * 返回非空日期字符串
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return yyyy-MM-dd
	 */
	public static String getStringDateTimeForDate(Date dateTime) {
		if (dateTime == null) {
			return Const.STRING_EMPTY;
		} else {
			LocalDateTime ldt = dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return ldt.format(Const.FORMATTER_DATETIME1);
		}
	}

	/**
	 * 返回非空日期字符串
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return yyyy-MM-dd
	 */
	public static String getStringDateForDate(Date dateTime) {
		if (dateTime == null) {
			return Const.STRING_EMPTY;
		} else {
			LocalDateTime ldt = dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return ldt.format(Const.FORMATTER_DATE1);
		}
	}

	/**
	 * 返回非空时间字符串
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return HH:mm:ss
	 */
	public static String getStringTimeForDate(Date dateTime) {
		if (dateTime == null) {
			return Const.STRING_EMPTY;
		} else {
			LocalDateTime ldt = dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return ldt.format(Const.FORMATTER_TIME);
		}
	}
	
	
	
	/**
	 * 返回非空时间字符串
	 * 
	 * @param dateTime
	 *            日期时间
	 * @return HH:mm
	 */
	public static String getStringMinuteForDate(Date dateTime) {
		if (dateTime == null) {
			return Const.STRING_EMPTY;
		} else {
			LocalDateTime ldt = dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return ldt.format(Const.FORMATTER_TIME_MINUTE);
		}
	}

	/**
	 * 得到系统当前日期时间
	 * 
	 * @return 当前日期时间
	 */
	public static Date getNow() {
		return new Date();
	}

	/**
	 * 时间校验
	 * @param param 需要校验时间
	 * @param beginDateTime 开始时间
	 * @param endDateTime 结束时间
	 * @return
	 */
	public static boolean checkDate(@NotNull Date param, @Nullable Date beginDateTime, @Nullable Date endDateTime) {
		if (beginDateTime == null) {
			if (endDateTime == null) {
				return true;
			} else {
				if (param.after(endDateTime)) {
					return false;
				} else {
					return true;
				}
			}
		} else {
			if (param.before(beginDateTime)) {
				return false;
			} else if (endDateTime == null) {
				return true;
			} else if (param.after(endDateTime)) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	/**
	 * 加n天
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date plusDays(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
	
	/**
	 * 加n月
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date plusMonths(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}
	

	/**
	 * 加n年
	 * @param date
	 * @param year
	 * @return
	 */
	public static Date plusYears(Date date,int year) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.YEAR, year);
	   return cal.getTime();
	}

	public static double getTimeDiff(Date begin,Date end){
		return (end.getTime() - begin.getTime())/1000.0;
	}

}


