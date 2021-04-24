package com.lming.ltts.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lming.ltts.common.core.entity.BaseIdEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Author: liangming.zhang
 * Date : 2021/4/24 - 12:19
 * Description:
 */
@Data
@TableName("t_order")
@ApiModel("orderEntity")
public class OrderEntity extends BaseIdEntity {

    @TableField
    @ApiModelProperty(name = "orderId",value = "订单Id",required = true)
    private String orderId;

    @ApiModelProperty(name = "orderAmount",value = "订单金额",required = true)
    @TableField
    private BigDecimal orderAmount;

}
