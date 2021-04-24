package com.lming.ltts.order.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lming.ltts.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Author: liangming.zhang
 * Date : 2021/4/24 - 15:35
 * Description:
 */
public interface OrderMapper extends BaseMapper<OrderEntity> {


    List<OrderEntity> selectByOrderId(@Param("orderId") String orderId);

}
