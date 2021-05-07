package com.lming.ltts.common.jwt.config;

import com.lming.ltts.common.jwt.interceptor.JwtInterceptor;
import com.lming.ltts.common.jwt.service.RedisTokenService;
import com.lming.ltts.common.jwt.service.TokenService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
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
@Import({WebConfig.class})
public class JwtAutoConfiguration {



    @ConditionalOnMissingBean
    @Bean
    public TokenService tokenService(){
        return new RedisTokenService();
    }



    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }

}
