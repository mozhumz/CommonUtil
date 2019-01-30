package com.hyj.util.str;

public class StrUtil {
	/**
	 * 去除字符串空白（\s 可以匹配空格、制表符、换页符等空白字符）
	 *
	 * @param str str
	 * @return String String
	 */
	public static String trim(String str) {
		if (str == null) {
			return str;
		}
		return str.replaceAll("\\s*", "");
	}

}
