package com.inossem.wms.common.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.lang.Nullable;

import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.constant.Const;

public class UtilString {

	/**
	 * 字符串是否为空
	 * 
	 * @param value
	 *            原字符串
	 * @return 真为空，假为不空
	 */
	public static boolean isNullOrEmpty(String value) {

		if (value == null || Const.STRING_NULL.equalsIgnoreCase(value.trim())
				|| Const.STRING_EMPTY.equals(value.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符串转换成int或负数
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标int
	 */
	public static int getIntOrNegative(String value) {
		if (isNullOrEmpty(value)) {
			return Const.NEGATIVE;
		} else {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				return Const.NEGATIVE;
			}
		}
	}

	/**
	 * 字符串转换成int或0
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标int
	 */
	public static int getIntOrZero(String value) {
		if (isNullOrEmpty(value)) {
			return 0;
		} else {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				return 0;
			}
		}
	}

	/**
	 * 字符串转换成Integer或null
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Integer
	 */
	public static Integer getIntegerOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换成double或0
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标double
	 */
	public static double getDoubleOrZero(String value) {
		if (isNullOrEmpty(value)) {
			return 0;
		} else {
			try {
				return Double.parseDouble(value);
			} catch (Exception e) {
				return 0;
			}
		}
	}

	/**
	 * 字符串转换成Double
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Double
	 */
	public static Double getDoubleOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				return Double.parseDouble(value);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换成Float或0
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标float
	 */
	public static float getFloatOrZero(String value) {
		if (isNullOrEmpty(value)) {
			return 0f;
		} else {
			try {
				return Float.parseFloat(value);
			} catch (Exception e) {
				return 0f;
			}
		}
	}

	/**
	 * 字符串转换成Float
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Float
	 */
	public static Float getFloatOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				return Float.parseFloat(value);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换成Long或0
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标long
	 */
	public static long getLongOrZero(String value) {
		if (isNullOrEmpty(value)) {
			return 0;
		} else {
			try {
				return Long.parseLong(value);
			} catch (Exception e) {
				return 0;
			}
		}
	}

	/**
	 * 字符串转换成Long
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Long
	 */
	public static Long getLongOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				return Long.parseLong(value);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换成byte[]
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标byte[]
	 */
	public static byte[] getByteOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				return value.getBytes();
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换成char[]
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标char[]
	 */
	public static char[] getCharArrayOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				return value.toCharArray();
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换成Boolean
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Boolean
	 */
	@Nullable
	public static Boolean getBooleanOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				return Boolean.parseBoolean(value);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换成Boolean或者false
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Boolean
	 */
	public static boolean getBooleanOrFalse(String value) {
		if (isNullOrEmpty(value)) {
			return false;
		} else {
			try {
				return Boolean.parseBoolean(value);
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 字符串转换成short或0
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标short
	 */
	public static short getShortOrZero(String value) {
		if (isNullOrEmpty(value)) {
			return 0;
		} else {
			try {
				return Short.parseShort(value);
			} catch (Exception e) {
				return 0;
			}
		}
	}

	/**
	 * 字符串转换成Short
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Short
	 */
	public static Short getShortOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				return Short.parseShort(value);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 字符串转换成Integer或0
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Integer
	 */
	public static Integer getIntegerOrZero(String value) {
		if (isNullOrEmpty(value)) {
			return Const.ZERO;
		} else {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				return Const.ZERO;
			}
		}
	}

	/**
	 * 字符串转换成Date或null
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Date
	 */
	public static Date getDateTimeOrNull(String value, SimpleDateFormat sf) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				ZonedDateTime zdt = LocalDateTime.parse(value, Const.FORMATTER_DATETIME1)
						.atZone(ZoneId.systemDefault());
				return Date.from(zdt.toInstant());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public static Date getDateTime(String value, DateTimeFormatter dtf) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				LocalTime lt = LocalTime.parse(value, dtf);
				ZonedDateTime zdt = LocalDateTime.of(LocalDate.now(), lt).atZone(ZoneId.systemDefault());
				Date strtodate = Date.from(zdt.toInstant());
				return strtodate;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * 字符串转换成Date或null
	 * 
	 * @param value
	 *            原字符串
	 * @return 目标Date
	 */
	public static Date getDateOrNull(String value) {
		if (isNullOrEmpty(value)) {
			return null;
		} else {
			try {
				DateTimeFormatter dtf = null;
				ZonedDateTime zdt = null;
				if (value.indexOf('-') > 0 && value.indexOf(':') > 0) {
					dtf = Const.FORMATTER_DATETIME1;
					zdt = LocalDateTime.parse(value, dtf).atZone(ZoneId.systemDefault());
				} else if (value.indexOf('/') > 0 && value.indexOf(':') > 0) {
					dtf = Const.FORMATTER_DATETIME2;
					zdt = LocalDateTime.parse(value, dtf).atZone(ZoneId.systemDefault());
				} else if (value.indexOf('-') > 0) {
					dtf = Const.FORMATTER_DATE1;
					zdt = LocalDate.parse(value,dtf).atStartOfDay(ZoneId.systemDefault());
				} else if (value.indexOf('/') > 0) {
					dtf = Const.FORMATTER_DATE3;
					zdt = LocalDate.parse(value,dtf).atStartOfDay(ZoneId.systemDefault());
				} else if (value.indexOf(':') > 0 && value.length() == 8) {
					dtf = Const.FORMATTER_TIME;
					LocalTime lt = LocalTime.parse(value, dtf);
					zdt = LocalDateTime.of(LocalDate.now(),lt).atZone(ZoneId.systemDefault());
				} else if (value.indexOf(':') > 0 && value.length() == 5) {
					dtf = Const.FORMATTER_TIME_MINUTE;
					LocalTime lt = LocalTime.parse(value, dtf);
					zdt = LocalDateTime.of(LocalDate.now(),lt).atZone(ZoneId.systemDefault());
				} else {
					dtf = Const.FORMATTER_DATE2;
					zdt = LocalDate.parse(value,dtf).atStartOfDay(ZoneId.systemDefault());
				}
				return Date.from(zdt.toInstant());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * 拆分字符串
	 * 
	 * @param value
	 *            待拆分的字符串
	 * @param separator
	 *            分隔符
	 * @return String[] 拆分后字符串数组
	 */
	public static String[] getStringArray(String value, String separator) {

		// 空返回，0长度
		if (isNullOrEmpty(value)) {
			return new String[0];
		}

		// 拆分
		String[] splitArray = value.split(separator);

		// 拆分后去掉null和""的字符串
		String[] retArray;
		ArrayList<String> list = new ArrayList<String>();
		if (splitArray != null && splitArray.length > 0) {
			int len = splitArray.length;
			for (int i = 0; i < len; i++) {
				if (!isNullOrEmpty((splitArray[i]))) {
					list.add(splitArray[i]);
				}
			}

			retArray = list.toArray(new String[list.size()]);
		} else {
			retArray = new String[0];
		}
		return retArray;
	}

	/**
	 * 将字符串转换num位字符串，不足num位的左补0
	 * 
	 * @param value
	 *            原字符串
	 * @param num
	 *            位数
	 * @return 左补0后的字符串
	 */
	public static String getStringForLeftInsertZero(String value, int num) {
		for (int i = 0; i < num; i++) {
			if (value.length() < num) {
				value = "0" + value;
			}
		}
		return value;
	}

	/**
	 * 除去尾随零
	 * 
	 * @param value
	 *            字符串
	 * @return
	 */
	public static BigDecimal getBigDecimalStripTrailingZeros(String value) {
		if (value == null) {
			return BigDecimal.ZERO;
		} else {
			return new BigDecimal(value).stripTrailingZeros();
		}
	}

	/**
	 * json转换
	 * 
	 * @param json
	 * @return
	 */
	public static Object getJSON(String json) {
		return JSONObject.parse(json);
	}

	/**
	 * 将一个驼峰型字符串转换为snake型字符串
	 * 
	 * @param name
	 * @return
	 */
	public static String getSnake(String name) {
		if (UtilString.isNullOrEmpty(name)) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		result.append(name.substring(0, 1).toLowerCase());
		for (int i = 1; i < name.length(); ++i) {
			String s = name.substring(i, i + 1);
			String slc = s.toLowerCase();
			if (!(s.equals(slc))) {
				result.append("_").append(slc);
			} else {
				result.append(s);
			}
		}
		return result.toString();
	}
}
