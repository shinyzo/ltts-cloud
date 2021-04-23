package com.lming.ltts.common.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:23
 * Description: 分配UUID,主键类型为String(since 3.3.0),使用接口IdentifierGenerator的方法nextUUID(默认default方法)
 */
@Data
public class BaseUUIDEntity implements Serializable {

    @TableId(type= IdType.ASSIGN_UUID)
    private Long id;

}
