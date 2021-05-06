package com.lming.ltts.log.server;

import com.lming.ltts.common.swagger.annotation.EnableKnife4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 20:01
 * Description:
 */
@SpringBootApplication
@EnableKnife4j2
@EnableDiscoveryClient
@MapperScan("com.lming.ltts.log.server.mapper")
public class LogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogServerApplication.class);
    }
}
