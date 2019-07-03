package com.hyj.util.common;

import lombok.extern.slf4j.Slf4j;

import com.hyj.util.exception.BaseException;
import com.hyj.util.param.CheckParamsUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URLEncoder;
import java.util.*;
import org.apache.commons.codec.binary.Base64;

/**
 * @author huyuanjia
 */
@Slf4j
public class CommonUtil {

	/**
	 * 实体类转map
	 *
	 * @param obj obj
	 * @return Map Map
	 */
	public static Map<String, Object> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			try {
				map.put(field.getName(), field.get(obj));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				log.error("objectToMap failed" + e);
			}
		}
		return map;
	}

	/**
	 * map转实体
	 * 
	 * @param map map
	 * @param beanClass beanClass
	 * @return Object Object
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) {
		if (map == null)
			return null;
		Object obj = null;
		try {

			obj = beanClass.newInstance();
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				int mod = field.getModifiers();
				if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
					continue;
				}

				field.setAccessible(true);
				if (map.get(field.getName()) == null) {
					continue;
				}
				field.set(obj, map.get(field.getName()));
			}
		} catch (Exception e) {
			throw new BaseException("系统错误");
		}

		return obj;
	}

	
	

	/**
	 * 将字符串数组转为list列表
	 * 
	 * @param listStr listStr
	 * @param object object
	 * @return List List
	 */
	public static List getListByStr(String listStr, Class object) {
		if (CheckParamsUtil.checkListStr(listStr)) {
			net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(listStr);
			return (List) net.sf.json.JSONArray.toCollection(jsonArray, object);
		}
		return null;
	}

	/**
	 * 处理中文乱码
	 * @param request request
	 * @param name 原字符串
	 * @return String
	 */
	public static String getName(HttpServletRequest request, String name){
		String agent = (String) request.getHeader("USER-AGENT");
		if (CheckParamsUtil.check(name)) {
			try {

				if (agent != null && agent.indexOf("Firefox") > -1) {// 处理火狐乱码
					name = "=?UTF-8?B?" + (new String(Base64
							.encodeBase64(name.getBytes("UTF-8")))) + "?=";
				} else {
					//其他浏览器
					name = URLEncoder.encode(name, "UTF-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return name;
	}

	/**
	 * 四舍五入保留n位小数
	 * @param d 原数字
	 * @param n 要保留的小数位数
	 * @return double
	 */
	public static Double get4To5(Double d,int n){
		if(d==null){
			return d;
		}
		return Double.parseDouble(String.format("%."+n+"f",d));
	}



}
