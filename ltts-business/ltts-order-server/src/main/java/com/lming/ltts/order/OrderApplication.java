package com.lming.ltts.order;

import com.lming.ltts.common.swagger.annotation.EnableLttsSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 16:59
 * Description:
 */
@SpringBootApplication
@EnableLttsSwagger2
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
