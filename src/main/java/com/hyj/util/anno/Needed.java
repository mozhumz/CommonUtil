package com.hyj.util.anno;

import java.lang.annotation.*;

/**
 * @author huyuanjia
 * 参数校验，加上该注解的属性才会校验
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Needed {
}
