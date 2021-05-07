package com.lming.ltts.common.jwt.annotation;

import java.lang.annotation.*;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 16:52
 * Description:
 */
@Target({ ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface JwtIgnore {

}
