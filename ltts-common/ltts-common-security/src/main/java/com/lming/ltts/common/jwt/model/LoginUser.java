package com.lming.ltts.common.jwt.model;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Author: liangming.zhang
 * Date : 2021/5/6 - 17:19
 * Description:
 */
@Data
public class LoginUser {

    private Long userId;

    private String userName;

    private Set<String> permissions;

    private Set<String> roles;

    private Long orgId;

    private Long loginTime;

    private Long expireTime;

    private String token;
}
