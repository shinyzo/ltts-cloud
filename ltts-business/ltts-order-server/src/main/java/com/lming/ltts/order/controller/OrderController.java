package com.lming.ltts.order.controller;

import com.lming.ltts.common.core.exception.LttsSystemException;
import com.lming.ltts.common.core.response.R;
import com.lming.ltts.order.entity.OrderEntity;
import com.lming.ltts.order.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 22:32
 * Description:
 */
@RestController
@Api(tags = "订单管理",value = "order api controller")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation(value = "订单查询",notes = "订单查询接口")
    @GetMapping("/order/query/{orderId}")
    public R<List<OrderEntity>> selectByOrderId(@PathVariable(value = "orderId") String orderId){

        return R.data(orderService.selectByOrderId(orderId));

    }








}
