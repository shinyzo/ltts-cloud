package com.lming.ltts.datasource.annotation;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 10:29
 * Description:
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS("master")
public @interface Master {


}
