package com.lming.ltts.order;

import com.lming.ltts.common.jwt.annotation.EnableJwt;
import com.lming.ltts.common.swagger.annotation.EnableKnife4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 16:59
 * Description:
 */
@SpringBootApplication
@EnableKnife4j2
@EnableDiscoveryClient
@EnableJwt
@MapperScan(value = "com.lming.ltts.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
