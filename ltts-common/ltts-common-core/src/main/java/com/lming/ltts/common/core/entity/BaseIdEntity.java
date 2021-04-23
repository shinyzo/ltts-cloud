package com.lming.ltts.common.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:23
 * Description: 采用数据库自增主键属性进行id自增
 */
@Data
public class BaseIdEntity implements Serializable {

    @TableId
    private Long id;

}
