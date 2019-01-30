package com.hyj.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hyj.util.exception.BaseException;
import com.hyj.util.exception.ErrorInfo;
import com.hyj.util.param.CheckParamsUtil;

public class TimeUtil {
	/**
	 * 根据date获取时间字符串
	 * 
	 * @param date date
	 */
	public static String getDateStr(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 根据字符串获取date
	 * 
	 * @param str str
	 */
	public static Date getDate(String str) {
		if (!CheckParamsUtil.check(str)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(str);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ErrorInfo.PARSE_TIME_ERROR.desc);
		}
	}
}
