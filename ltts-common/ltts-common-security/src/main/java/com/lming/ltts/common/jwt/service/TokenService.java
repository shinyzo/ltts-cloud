package com.lming.ltts.common.jwt.service;

import com.lming.ltts.common.jwt.model.LoginUser;

/**
 * Author: liangming.zhang
 * Date : 2021/5/7 - 14:18
 * Description:
 */
public interface TokenService {

    String createToken(LoginUser loginUser);

    LoginUser parseToken();

    boolean isExpired();
}
