package com.lming.ltts.common.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lming.ltts.common.core.entity.IdEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:23
 * Description: 采用数据库自增主键属性进行id自增
 */
@Data
public class BaseIdEntity implements IdEntity {

    @TableId
    private Long id;

}
