package com.hyj.util.time;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.hyj.util.exception.BaseException;
import com.hyj.util.exception.ErrorInfo;
import com.hyj.util.param.CheckParamsUtil;

public class TimeUtil {
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 根据date获取时间字符串
	 * 
	 * @param date date
	 * @return String String
	 */
	public static String getDateStr(Date date) {
		if (date == null) {
			return null;
		}
		return sdf.format(date);
	}

	/**
	 * 根据字符串获取date
	 * 
	 * @param str str
	 * @return Date Date
	 */
	public static Date getDate(String str) {
		if (!CheckParamsUtil.check(false,str)) {
			return null;
		}
		
		try {
			Date date = sdf.parse(str);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorInfo.PARSE_TIME_ERROR.desc);
		}
	}
	
	/**
	 * 获取当前时间字符串 
	 * @return str yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDateStr() {
		return sdf.format(new Date());
	}
}
