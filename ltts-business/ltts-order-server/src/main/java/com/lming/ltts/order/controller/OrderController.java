package com.lming.ltts.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lming.ltts.common.core.exception.LttsSystemException;
import com.lming.ltts.common.core.response.R;
import com.lming.ltts.common.log.annotation.LttsLog;
import com.lming.ltts.common.log.enums.LogType;
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

    @ApiOperation(value = "创建订单(主库)",notes = "创建订单")
    @GetMapping("/order/create")
    @LttsLog(title = "创建订单")
    public R<List<OrderEntity>> createOrder(OrderEntity orderEntity){
        orderService.save(orderEntity);
        return R.success();

    }

    @ApiOperation(value = "订单查询",notes = "订单查询接口")
    @GetMapping("/order/query/{orderId}")
    @LttsLog(title = "查询订单")
    public R<List<OrderEntity>> selectSlaveOrder(@PathVariable(value = "orderId") String orderId){

        return R.data(orderService.selectByOrderId2(orderId));

    }

    @ApiOperation(value = "分页查询",notes = "分页查询")
    @GetMapping("/order/page")
    public R page(){

        Page page1 = new Page(1,1);

        return R.data(orderService.page(page1));
    }








}
