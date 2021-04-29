package com.lming.ltts.common.jwt.annotation;

import com.lming.ltts.common.jwt.config.JwtAutoConfiguration;
import com.lming.ltts.common.jwt.config.JwtProperties;
import com.lming.ltts.common.jwt.config.WebConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Author: liangming.zhang
 * Date : 2021/4/29 - 13:34
 * Description:
 */
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({JwtAutoConfiguration.class})
@ConditionalOnWebApplication
public @interface EnableJwt {

}
