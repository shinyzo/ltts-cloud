package com.lming.ltts.order;

import com.lming.ltts.common.swagger.annotation.EnableKnife4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 16:59
 * Description:
 */
@SpringBootApplication
@EnableKnife4j2
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
