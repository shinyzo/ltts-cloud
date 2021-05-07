package com.lming.ltts.api.log.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Author: liangming.zhang
 * Date : 2021/4/28 - 16:23
 * Description:
 */
@EnableFeignClients("com.lming.ltts.api.log.feign")
@Configuration
public class FeignAutoConfiguration {


}
