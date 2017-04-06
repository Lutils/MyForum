package com.ljc.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * @author LJC
 * response输出工具类
 */
public class ResponseUtils {
	
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