package com.inossem.wms.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.regex.Pattern;

import com.inossem.wms.constant.Const;

public class UtilObject {

	/**
	 * Object 转String,空则返回""
	 * 
	 * @param obj
	 *            原Object
	 * @return String
	 */
	public static String getStringOrEmpty(Object obj) {
		if (obj == null) {
			return Const.STRING_EMPTY;
		} else if (obj instanceof String) {
			String s = (String) obj;
			if (UtilString.isNullOrEmpty(s)) {
				return Const.STRING_EMPTY;
			} else {
				return s;
			}
		} else if (obj instanceof BigDecimal) {
			BigDecimal bigDecimal = (BigDecimal) obj;
			return bigDecimal.toPlainString();
		} else if (obj instanceof Date) {
			Date dateTime = (Date) obj;
			return UtilDate.getStringDateTimeForDate(dateTime);
		} else if (obj instanceof LocalDateTime) {
			LocalDateTime dateTime = (LocalDateTime) obj;
			return UtilLocalDateTime.getStringDateTimeForLocalDateTime(dateTime);
		} else if (obj instanceof LocalDate) {
			LocalDate date = (LocalDate) obj;
			return UtilLocalDate.getStringDateForLocalDate(date);
		} else if (obj instanceof LocalTime) {
			LocalTime time = (LocalTime) obj;
			return UtilLocalTime.getStringTimeForLocalTime(time);
		} else if (obj instanceof Integer) {
			Integer integer = (Integer) obj;
			return integer.toString();
		} else if (obj instanceof Long) {
			Long l = (Long) obj;
			return l.toString();
		} else if (obj instanceof Double) {
			Double d = (Double) obj;
			return d.toString();
		} else if (obj instanceof Byte) {
			Byte b = (Byte) obj;
			return b.toString();
		} else {
			return obj.toString();
		}
	}

	/**
	 * Object转String,Object不存在则返回null
	 * 
	 * @param obj
	 *            原Object
	 * @return String
	 */
	public static String getStringOrNull(Object obj) {
		if (obj == null) {
			return null;
		} else if (obj instanceof String) {
			String s = (String) obj;
			if (UtilString.isNullOrEmpty(s)) {
				return null;
			} else {
				return s;
			}
		} else {
			return getStringOrEmpty(obj);
		}
	}

	/**
	 * Object转Long,Object不存在则返回null
	 * 
	 * @param obj
	 *            原Object
	 * @return Long
	 */
	public static Long getLongOrNull(Object obj) {
		if (obj == null) {
			return null;
		} else {
			try {
				return Long.parseLong(obj.toString().trim());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 
	 * Object转Integer,Object不存在则返回null
	 * 
	 * @param obj
	 *            原Object
	 * @return Integer
	 */
	public static Integer getIntegerOrNull(Object obj) {
		try {
			if (obj == null) {
				return null;
			} else {
				String str = obj.toString().trim();
				if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
					return null;
				} else {
					Double valueDouble = Double.parseDouble(obj.toString().trim());
					return valueDouble.intValue();
				}
			}
		} catch (

		Exception ex) {
			return null;
		}
	}

	/**
	 * 
	 * Object转int,Object不存在则返回null
	 * 
	 * @param obj
	 *            原Object
	 * @return int
	 */
	public static int getIntOrZero(Object obj) {
		if (null == obj) {
			return 0;
		} else {
			try {
				String str = obj.toString().trim();
				if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
					return 0;
				} else {
					return Integer.parseInt(str);
				}
			} catch (Exception e) {
				return 0;
			}
		}
	}

	/**
	 * 
	 * Object转BigDecimal,Object不存在则返回0
	 * 
	 * @param obj
	 *            原Object
	 * @return BigDecimal
	 */
	public static BigDecimal getBigDecimalOrZero(Object obj) {
		BigDecimal ret = BigDecimal.ZERO;
		if (obj != null) {
			if (obj instanceof BigDecimal) {
				ret = (BigDecimal) obj;
			} else if (obj instanceof String) {
				String str = obj.toString().trim();
				if (str.length() > 0) {
					ret = new BigDecimal(str);
				}
			} else if (obj instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) obj);
			} else if (obj instanceof Number) {
				// ret = new BigDecimal(((Number) obj).doubleValue());
				ret = new BigDecimal(((Number) obj).toString());
			} else {
				throw new ClassCastException(
						"Not possible to coerce [" + obj + "] from class " + obj.getClass() + " into a BigDecimal.");
			}
		}
		ret = UtilBigDecimal.getBigDecimalStripTrailingZeros(ret);
		ret = new BigDecimal(ret.toPlainString());
		return ret;
	}

	/**
	 * 
	 * Object转Byte,Object不存在则返回null
	 * 
	 * @param obj
	 *            原Object
	 * @return Byte
	 */
	public static Byte getByteOrNull(Object obj) {
		if (obj == null) {
			return null;
		} else {
			try {
				return Byte.parseByte(obj.toString().trim());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 
	 * Object转BigDecimal,Object不存在则返回0
	 * 
	 * @param obj
	 *            原Object
	 * @return BigDecimal
	 */
	public static BigDecimal getBigDecimal(Object value) {
		BigDecimal ret = null;
		if (value != null && !"".equals(value)) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
						+ " into a BigDecimal.");
			}
		} else {
			ret = BigDecimal.ZERO;
		}
		return ret;
	}

	/**
	 * 过滤任意(script,html,style)标签符,返回纯文本
	 * 
	 * @param inputString
	 *            原Object
	 * @return String
	 */
	public static String HtmlToText(Object inputString) {
		if (null == inputString) {
			return null;
		}
		String htmlStr = inputString.toString(); // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		java.util.regex.Matcher m_script;
		Pattern p_style;
		java.util.regex.Matcher m_style;
		Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
			textStr = htmlStr;
		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr;// 返回文本字符串

	}

}
