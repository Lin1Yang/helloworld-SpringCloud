package com.inossem.wms.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class UtilMD5 {

	private static final int HEX = 16;

	private static final int ADD_NUMBER = 256;

	private static final String ALGORITHM = "MD5"; // 算法

	// 十六进制下数字到字符的映射数组
	private static final String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/**
	 * 利用MD5加密文件
	 *
	 * @param file
	 *            待加密的文件对象
	 * @return 加密后的字符串
	 */
	public static String encryptFile(File file) {
		String result = "";
		try {
			// 确定计算方法
			MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
			FileInputStream mFileInputStream = new FileInputStream(file);
			byte[] buffer = new byte[1024 * 8];
			int length;
			while ((length = mFileInputStream.read(buffer)) != -1) {
				messageDigest.update(buffer, 0, length);
			}
			result = byteArrayToHexString(messageDigest.digest());
			mFileInputStream.close();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			result = "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			result = "";
		} catch (IOException e) {
			e.printStackTrace();
			result = "";
		}
		return result;
	}

	/**
	 * 利用MD5进行加密
	 *
	 * @param data
	 *            待加密的字符串
	 * @return 加密后的字符串
	 */
	// MD5加密
	public static String encrypt(String data) {
		String result = "";
		try {
			if (data != null && !"".equals(data)) {
				// 确定计算方法
				MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
				// MD5加密
				byte[] md5Result = messageDigest.digest(data.getBytes());
				// 字节数组转成十六进制字符串
				result = byteArrayToHexString(md5Result);
				return result.toLowerCase(Locale.getDefault());
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			result = "";
		}
		return result;
	}

	/**
	 * 转换字节数组为十六进制字符串
	 *
	 * @param b
	 *            字节数组
	 * @return 十六进制字符串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * 将字节转化成十六进制形式的字符串
	 *
	 * @param b
	 *            字节数组
	 * @return 十六进制字符串
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = ADD_NUMBER + n;
		}
		int d1 = n / HEX;
		int d2 = n % HEX;
		return HEX_DIGITS[d1] + HEX_DIGITS[d2];
	}

	/**
	 * 检验加密 使用人员无需关心
	 *
	 * @param newData
	 *            需要加密的内容
	 * @param newData
	 *            之前加密后的内容
	 * @return true代表检验通过
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean checkEncryption(String newData, String code) {
		if (encrypt(newData).equals(code)) {
			return true;
		} else {
			return false;
		}
	}
}
