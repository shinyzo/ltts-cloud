package com.lming.ltts.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 22:32
 * Description:
 */
@RestController
public class OrderController {

    @GetMapping("/order/index")
    public String index(){

        return "order index";

    }








}
