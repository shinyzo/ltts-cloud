package com.lming.ltts.common.log.annotation;

import com.lming.ltts.common.log.enums.LogType;
import org.springframework.core.annotation.AliasFor;

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

    @AliasFor("name")
    String title() default "";

    @AliasFor("title")
    String name() default "";

}
