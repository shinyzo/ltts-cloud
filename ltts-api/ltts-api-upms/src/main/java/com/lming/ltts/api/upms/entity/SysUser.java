package com.lming.ltts.api.upms.entity;

import lombok.Data;

/**
 * Author: liangming.zhang
 * Date : 2021/5/7 - 20:52
 * Description:
 */
@Data
public class SysUser{

    private Long id;

    private String userName;

    private int status;

    private Long orgId;

}
