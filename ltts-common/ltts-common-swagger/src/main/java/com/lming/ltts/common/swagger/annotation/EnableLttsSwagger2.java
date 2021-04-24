package com.lming.ltts.common.swagger.annotation;

import com.lming.ltts.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 15:44
 * Description:
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ SwaggerAutoConfiguration.class })
public @interface EnableLttsSwagger2 {

}
