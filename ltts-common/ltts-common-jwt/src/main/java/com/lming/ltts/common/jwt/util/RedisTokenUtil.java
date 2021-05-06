package com.lming.ltts.common.jwt.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.lming.ltts.common.core.exception.LttsAuthException;
import com.lming.ltts.common.jwt.config.JwtProperties;
import com.lming.ltts.common.jwt.enums.AuthResultEnum;
import com.lming.ltts.common.jwt.model.LoginUser;
import com.lming.ltts.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.TimeUnit;


/**
 * Author: liangming.zhang
 * Date : 2021/5/6 - 17:10
 * Description:
 */
@Component
public class RedisTokenUtil {

    public static final Long MILLIS_SECOND = 1000L;

    @Autowired
    private RedisService redisService;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 生成token
     * @param loginUser
     * @return
     */
    public String createToken(LoginUser loginUser){
        String token = IdUtil.fastSimpleUUID();
        loginUser.setToken(token);
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + jwtProperties.getExpiresSecond()*1000);
        refreshToken(loginUser);
        redisService.setCacheObject(getTokenKey(token), loginUser,jwtProperties.getExpiresSecond(), TimeUnit.SECONDS);
        return token;
    }


    /**
     * token续期
     * @param loginUser
     */
    public void refreshToken(LoginUser loginUser){

        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + jwtProperties.getExpiresSecond()*1000);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisService.setCacheObject(userKey, loginUser, jwtProperties.getExpiresSecond(), TimeUnit.SECONDS);
    }


    /**
     * 解析token
     * @return
     */
    public LoginUser parseToken(){
        String headerToken = getRequestToken();
        if(StrUtil.isNotEmpty(headerToken) && headerToken.startsWith(jwtProperties.getTokenPrefix())) {
           String token = headerToken.substring(jwtProperties.getTokenPrefix().length());
           LoginUser loginUser = redisService.getCacheObject(getTokenKey(token));
           if(loginUser == null || loginUser.getLoginTime() + loginUser.getExpireTime() < System.currentTimeMillis()){
               throw new LttsAuthException(AuthResultEnum.AUTH_TOKEN_EXPIRED);
           }
           refreshToken(loginUser);
           return loginUser;
        }else {
            throw new LttsAuthException(AuthResultEnum.AUTH_TOKEN_EMPTY);
        }
    }

    private String getRequestToken(){
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
        String headerToken = servletRequestAttributes.getRequest().getHeader(jwtProperties.getTokenHeaderName());
        return headerToken;
    }

    private String getTokenKey(String token){
        return "token:"+ token;
    }
}
