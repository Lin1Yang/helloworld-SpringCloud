package com.inossem.wms.common.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.inossem.wms.common.exception.TextException;
import com.inossem.wms.constant.Const;

public class UtilText {
	
	private static final Logger logger = LoggerFactory.getLogger(UtilText.class);

	/**
	 * 返回国际化信息
	 * 
	 * @param args
	 *            可以传多个字符串，第一个字符串是要显示的key名,其他而参数
	 * @return 国际化信息
	 */
	public static String getI18nText(String key, String... args) {
		JSONObject json = new JSONObject();
		json.put("0", key);
		for (int i = 0; i < args.length; i++) {
			json.put(String.valueOf(i + 1), args[i]);
		}
		return Const.I18N_ + json.toString() + Const._MSG;
	}
	
	/**
	 * 返回国际化字段格式的字符串
	 * 
	 * @param key 需要国际化的字段名，key必须在name_message_xxx.properties中存在
	 * @return
	 * @author libin
	 */
	public static String getI18nName(String key) {
		return Const.I18N_ + key + Const._NAME;
	}
	
	/**
	 * 
	 * @param lang	国际化 中文  英文
	 * @param key	枚举key值
	 * @return
	 */
	public static String getNameMessage(String lang, String key) {

		String message = Const.STRING_EMPTY;
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(Const.NAME_MESSAGE + lang.toLowerCase());
			MessageFormat format = new MessageFormat(new String(bundle.getString(key.toLowerCase())));
			message = format.format(null);
		} catch (Exception e) {
			logger.error(String.format("获取国际化文本失败，语言码：%s，目标文本：%s", lang, key));
			throw new TextException(key.toLowerCase());
		}
		return message;
	}

	public static String getTextMessage(String lang, String msg) {

		String message = Const.STRING_EMPTY;
		String key = Const.STRING_EMPTY;
		try {
			JSONObject json = JSONObject.parseObject(msg.substring(5, msg.length() - 4));
			String[] args = new String[json.size() - 1];
			for (String jsonkey : json.keySet()) {
				if (Const.STRING_ZERO.equals(jsonkey)) {
					key = json.getString(jsonkey);
				} else {
					args[UtilString.getIntOrNegative(jsonkey) - 1] = json.getString(jsonkey);
				}
			}
			ResourceBundle bundle = ResourceBundle.getBundle(Const.TEXT_MESSAGES + lang.toLowerCase());
			MessageFormat format = new MessageFormat(new String(bundle.getString(key.toLowerCase())));
			message = format.format(args);
		} catch (Exception e) {
			logger.error(String.format("获取国际化文本失败，语言码：%s，目标文本：%s", lang, msg));
			throw new TextException(key.toLowerCase());
		}
		return message;
	}
	
	public static String getMessage(String lang, String key) {
		String message = Const.STRING_EMPTY;
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(Const.RETURN_CODE_MESSAGES + lang.toLowerCase());
			message = bundle.getString(key.toLowerCase());
		} catch (Exception e) {
			logger.error("获取国际化文本失败，语言码：{}，目标文本：{}", lang, key);
			logger.error(e.getMessage());
			throw new TextException(e.getMessage());
		}
		return message;
	}
	
	public static String getMessage(String lang, String key, String[] args) {

		String message = Const.STRING_EMPTY;
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(Const.RETURN_CODE_MESSAGES + lang.toLowerCase());
			if (args != null && args.length > 0) {
				MessageFormat format = new MessageFormat(new String(bundle.getString(key.toLowerCase())));
				message = format.format(args);
			} else {
				message = bundle.getString(key.toLowerCase());
			}
		} catch (Exception e) {
			logger.error("获取国际化文本失败，语言码：{}，目标文本：{}", lang, key);
			logger.error(e.getMessage());
			throw new TextException(e.getMessage());
		}
		return message;
	}
	
}
