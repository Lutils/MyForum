package com.ljc.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LJC 
 * 字符串工具类
 */
public class StringUtils {

	/**
	 * 空字符串
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 判断是否为空白字符串
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 去除字符串中的html标签
	 * @param html
	 * @return
	 */
	public static String replaceHtml(String html) {
		if (StringUtils.isBlank(html)) {
			return StringUtils.EMPTY_STRING;
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll(StringUtils.EMPTY_STRING);
		return s;
	}

	/**
	 * 字符串MD5加密
	 * @param s
	 * @return
	 */
	public final static String MD5(String str) {
		try {
			if (!StringUtils.isEmpty(str)) {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				byte[] digest = messageDigest.digest(str.getBytes("utf-8"));
				return new BigInteger(digest).toString(16);
			} else {
				return "";
			}
		} catch (Exception e) {
			throw new RuntimeException("字符串加密失败!" + e);
		}
	}
	
//	public static void main(String[] args) {
//		System.out.println(MD5("123"));
//	}

}