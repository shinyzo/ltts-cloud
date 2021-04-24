package com.lming.ltts.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lming.ltts.order.entity.OrderEntity;

import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/4/24 - 15:34
 * Description:
 */
public interface IOrderService extends IService<OrderEntity> {

    OrderEntity getOrderById(Long id);

    List<OrderEntity> selectByOrderId(String orderId);

}
