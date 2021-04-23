package com.lming.ltts.common.core.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 13:28
 * Description:
 */
@Data
public class BaseEntity extends BaseIdEntity {

    private Date createTime;

    private Long createUser;

    private Date updateTime;

    private Long updateUser;

}
