package com.lming.ltts.common.jwt.config;

import com.lming.ltts.common.jwt.util.RedisTokenUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 16:39
 * Description:
 */
@Configuration
@ConditionalOnProperty(value = "ltts.jwt.enabled",havingValue = "true",matchIfMissing = true)
@EnableConfigurationProperties(JwtProperties.class)
//@ComponentScan(basePackages = {"com.lming.ltts.common.jwt"})
@Import({WebConfig.class, RedisTokenUtil.class})
public class JwtAutoConfiguration {


}
