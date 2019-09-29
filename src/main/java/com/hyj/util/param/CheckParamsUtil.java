package com.hyj.util.param;

import java.lang.reflect.Field;
import java.util.List;

import com.hyj.util.anno.Needed;
import com.hyj.util.exception.BaseException;
import com.hyj.util.exception.ErrorInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 参数校验
 *
 * @author huyuanjia
 */
@Slf4j
public class CheckParamsUtil {

    /**
     * string判空
     *
     * @param params 参数数组
     * @return boolean true校验通过 false参数有空值
     */
    public static boolean check(String... params) {
        for (String param : params) {
            if (param == null
                    || param.replaceAll("\\s*", "").equals("")
                    || param.equalsIgnoreCase("null")
                    || param.equalsIgnoreCase("undefined")) {
                return false;
            }
        }
        return true;
    }

    /**
     * string判空
     *
     * @param isThrow 是否抛异常 true 参数有空时，抛出异常；false 参数有空时 返回false
     * @param params  参数数组
     * @return boolean true校验通过 false参数有空值
     */
    public static boolean check(boolean isThrow, String... params) {
        boolean flag = check(params);
        if (!flag) {
            if (isThrow) {
                throw new BaseException(ErrorInfo.PARAMS_ERROR.desc);
            }
            return false;
        }
        return true;
    }

    /**
     * 对象列表判空
     *
     * @param params params
     */
    public static void checkObjs(Object... params) {
        for (Object obj : params) {
            if (obj == null) {
                throw new BaseException(ErrorInfo.PARAMS_ERROR.desc);
            }
        }
    }

    /**
     * 列表判空
     *
     * @param params 参数数组
     */
    public static void checkList(List params) {
        if (params == null) {
            throw new BaseException(ErrorInfo.PARAMS_ERROR.desc);
        }
        for (Object param : params) {
            if (param == null) {
                throw new BaseException(ErrorInfo.PARAMS_ERROR.desc);
            }
        }
    }

    /**
     * 列表判空
     *
     * @param params 参数数组
     * @return boolean boolean
     */
    public static boolean checkList_boolean(List params) {
        if (params == null || params.isEmpty()) {
            return false;
        }

        for (Object param : params) {
            if (param == null) {
                return false;
            }
        }
        return true;
    }


    /**
     * string List判空
     *
     * @param params 参数数组
     * @return boolean boolean
     */
    public static boolean checkListStr(String... params) {
        for (String param : params) {
            if (param == null
                    || param.replaceAll("\\s*", "").equals("")
                    || param.equalsIgnoreCase("null")
                    || param.equalsIgnoreCase("undefined") || param.equals("[]")) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查实体类各个属性值是否为空(有Needed注解的属性才会校验)
     *
     * @param isThrow 是否抛异常 true 参数有空时，抛出异常；false 参数有空时 返回false
     * @param obj     实体对象
     * @return true 参数校验通过 false参数有空值
     */
    public static boolean checkObj(Object obj, boolean isThrow) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Needed needed = field.getAnnotation(Needed.class);
                if (needed != null) {
                    return check(isThrow, field.get(obj) + "");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                log.error("checkObj Exception" + e);
                if (isThrow) {
                    throw new BaseException(ErrorInfo.UNKNOWN_ERROR.desc);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
