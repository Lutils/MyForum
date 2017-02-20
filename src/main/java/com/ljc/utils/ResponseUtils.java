package com.ljc.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LJC
 * response输出工具类
 */
public class ResponseUtils {

	static Logger logger = LoggerFactory.getLogger(ResponseUtils.class);
	
	/**
	 * 输出Object对象
	 * @param response
	 * @param o
	 */
	public static void write(HttpServletResponse response, Object o) {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			logger.info("response输出失败！" + e);
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.println(o.toString());
				out.flush();
				out.close();
			}
		}
	}
}