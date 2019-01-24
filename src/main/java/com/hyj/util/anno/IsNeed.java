package com.hyj.util.anno;

import java.lang.annotation.*;

/**
 * @author huyuanjia
 * @date 2018/12/4 11:29
 * 前端参数-是否必须
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsNeed {
    boolean flag();
}
