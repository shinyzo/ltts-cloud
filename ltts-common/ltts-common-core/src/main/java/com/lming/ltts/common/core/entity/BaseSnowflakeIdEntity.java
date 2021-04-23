package com.lming.ltts.common.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:23
 * Description: 分配ID(主键类型为Number(Long和Integer)或String)(since 3.3.0),使用接口IdentifierGenerator的方法nextId(默认实现类为DefaultIdentifierGenerator雪花算法)
 */
@Data
public class BaseSnowflakeIdEntity implements Serializable {

    @TableId(type= IdType.ASSIGN_ID)
    private Long id;

}
