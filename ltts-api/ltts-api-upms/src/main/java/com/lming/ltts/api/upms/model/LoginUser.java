package com.lming.ltts.api.upms.model;

import lombok.Data;

import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/5/6 - 17:14
 * Description:
 */
@Data
public class LoginUser {

    private Long userId;

    private String userName;

    private List<String> permissions;

    private String role;
}
