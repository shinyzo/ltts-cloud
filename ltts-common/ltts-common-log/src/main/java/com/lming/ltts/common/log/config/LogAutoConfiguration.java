package com.lming.ltts.common.log.config;

import com.lming.ltts.common.log.aspect.LttsControllerLogAspect;
import com.lming.ltts.common.log.handler.LogHandler;
import com.lming.ltts.common.log.service.AsyncLogService;
import com.lming.ltts.common.log.service.impl.LocalPrintLogServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

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
public class LogAutoConfiguration {


    @Bean
    public LttsControllerLogAspect lttsControllerLogAspect(){
        return new LttsControllerLogAspect();
    }

    /**
     * 采用java SPI进行数据存储
     * @return
     */
    @Bean
    public AsyncLogService asyncLogService(){

        AsyncLogService asyncLogService =  null;
        ServiceLoader<AsyncLogService> serviceServiceLoader = ServiceLoader.load(AsyncLogService.class);

        Iterator<AsyncLogService> itr = serviceServiceLoader.iterator();
        while(itr.hasNext()){
            asyncLogService = itr.next();
            return asyncLogService;
        }

        return new LocalPrintLogServiceImpl();
    }

    @Bean
    public LogHandler logHandler(){
        return new LogHandler();
    }

}
