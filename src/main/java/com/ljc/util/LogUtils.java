package com.ljc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LJC
 * 日志工具类
 */
public class LogUtils {

	//标记是否输出日志
	private static boolean FLAG = true;

	static Logger logger = LoggerFactory.getLogger(LogUtils.class);
	
	/**
	 * 输出info日志
	 * @param msg
	 */
	public static void info(String msg){
		if(FLAG){
			logger.info(msg);
		}
	}
	/**
	 * 输出info日志
	 * @param format
	 * @param arguments
	 */
	public static void info(String format, Object... arguments){
		if(FLAG){
			logger.info(format, arguments);
		}
	}
}
