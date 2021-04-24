package com.lming.ltts.common.swagger.annotation;

import com.lming.ltts.common.swagger.config.Knife4jConfig;
import com.lming.ltts.common.swagger.config.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(SwaggerProperties.class)
@Import({ Knife4jConfig.class })
public @interface EnableKnife4j2 {

}
