package com.lming.ltts.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lming.ltts.datasource.annotation.Master;
import com.lming.ltts.datasource.annotation.Slave;
import com.lming.ltts.order.entity.OrderEntity;
import com.lming.ltts.order.mapper.OrderMapper;
import com.lming.ltts.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/4/24 - 15:36
 * Description:
 */
@Service
@Master
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderEntity getOrderById(Long id) {
        return orderMapper.selectById(id);
    }

    @Override
    public List<OrderEntity> selectByOrderId(String orderId) {

        return orderMapper.selectByOrderId(orderId);
    }

    @Override
    @Slave
    public List<OrderEntity> selectByOrderId2(String orderId) {

        return orderMapper.selectByOrderId(orderId);
    }


}
