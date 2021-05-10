package com.lming.ltts.common.log.config;

import com.lming.ltts.common.log.aspect.LttsControllerLogAspect;
import com.lming.ltts.common.log.factory.LogHandlerFactory;
import com.lming.ltts.common.log.handler.HttpRestLogHandler;
import com.lming.ltts.common.log.handler.LocalPrintLogHandler;
import com.lming.ltts.common.log.handler.LogHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Author: liangming.zhang
 * Date : 2021/4/26 - 13:31
 * Description:
 */
@Configuration
@EnableAsync
@EnableConfigurationProperties(LogProperties.class)
@ConditionalOnProperty(name = "ltts.log.enabled", havingValue ="true",matchIfMissing = false)
@ComponentScan("com.lming.ltts.common.log.handler")
public class LogAutoConfiguration {


    @Bean
    public LttsControllerLogAspect lttsControllerLogAspect(){
        return new LttsControllerLogAspect();
    }

    @Bean
    public LogHandlerFactory logHandlerFactory(){
        return new LogHandlerFactory();
    }

}
