package com.lming.ltts.common.log.annotation;

import com.lming.ltts.common.log.enums.LogType;

import java.lang.annotation.*;

/**
 * Author: liangming.zhang
 * Date : 2021/4/22 - 9:52
 * Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LttsLog {

    /**
     * 日志类型
     * @return
     */
    LogType type() default  LogType.NORMAL;

    /**
     * 系统名称
     * @return
     */
    String system() default "";

}
