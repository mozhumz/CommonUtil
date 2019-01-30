package com.hyj.util.common;

import lombok.extern.slf4j.Slf4j;

import com.hyj.util.exception.BaseException;
import com.hyj.util.param.CheckParamsUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

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

}
