package com.lming.ltts.common.jwt.service;

import com.lming.ltts.common.jwt.config.JwtProperties;
import com.lming.ltts.common.jwt.model.LoginUser;
import com.lming.ltts.common.jwt.util.JwtTokenUtil;
import com.lming.ltts.common.jwt.util.ServletUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Author: liangming.zhang
 * Date : 2021/5/7 - 14:20
 * Description:
 */
@Service
public class JwtTokenService implements TokenService {

    @Autowired
    private static JwtProperties jwtProperties;

    @Override
    public String createToken(LoginUser loginUser) {
        return JwtTokenUtil.createJWT(loginUser,jwtProperties);
    }

    @Override
    public LoginUser parseToken() {
        String token = ServletUtil.getRequestToken(jwtProperties.getTokenHeaderName());
        Claims claims = JwtTokenUtil.parseJWT(token,jwtProperties.getBase64Secret());
        Long userId = claims.get("userId",Long.class);
        String userName = claims.getSubject();
        Set<String> roles = claims.get("roles", Set.class);
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(userId);
        loginUser.setUserName(userName);
        loginUser.setRoles(roles);
        return loginUser;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
