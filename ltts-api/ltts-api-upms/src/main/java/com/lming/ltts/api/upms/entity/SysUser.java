package com.lming.ltts.api.upms.entity;

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * Author: liangming.zhang
 * Date : 2021/5/7 - 20:52
 * Description:
 */
@Data
public class SysUser{

    private Long userId;

    private String userName;

    private String password;

    private Set<String> permissions;

    private Set<String> roles;

    private Long orgId;

    private String salt;

    private String email;

    private Date creteDate;

    private Date updateDate;

    private int status;

}
