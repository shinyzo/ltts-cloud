package com.lming.ltts.common.jwt.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.lming.ltts.common.core.exception.LttsAuthException;
import com.lming.ltts.common.jwt.config.JwtProperties;
import com.lming.ltts.common.jwt.enums.AuthResultEnum;
import com.lming.ltts.common.jwt.keys.CacheKeys;
import com.lming.ltts.common.jwt.model.LoginUser;
import com.lming.ltts.common.jwt.util.ServletUtil;
import com.lming.ltts.common.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.TimeUnit;

/**
 * Author: liangming.zhang
 * Date : 2021/5/7 - 14:31
 * Description:
 */
@Service
@Slf4j
public class RedisTokenService implements TokenService {

    public static final Long MILLIS_SECOND = 1000L;



    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private RedisService redisService;

    /**
     * 生成token
     * @param loginUser
     * @return
     */
    public String createToken(LoginUser loginUser){
        String token = IdUtil.fastSimpleUUID();
        loginUser.setToken(token);
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + jwtProperties.getExpiresSecond());
        redisService.setCacheObject(getTokenKey(token), loginUser,jwtProperties.getExpiresSecond()/MILLIS_SECOND, TimeUnit.SECONDS);
        log.info("==> token:{},userInfo:{}",token,loginUser);
        return token;
    }



    /**
     * token续期
     * @param loginUser
     */
    public void refreshToken(LoginUser loginUser){
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + jwtProperties.getExpiresSecond());
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisService.setCacheObject(userKey, loginUser, jwtProperties.getExpiresSecond()/MILLIS_SECOND, TimeUnit.SECONDS);
    }


    /**
     * 解析token
     * @return
     */
    @Override
    public LoginUser parseToken(){
        final String headerToken = ServletUtil.getRequestToken(jwtProperties.getTokenHeaderName());
        if(StrUtil.isBlank(headerToken) || !headerToken.startsWith(jwtProperties.getTokenPrefix())) {
            throw new LttsAuthException(AuthResultEnum.AUTH_TOKEN_EMPTY);
        }

        String token = headerToken.substring(jwtProperties.getTokenPrefix().length());
        LoginUser loginUser = redisService.getCacheObject(getTokenKey(token));
        if(loginUser == null || loginUser.getExpireTime() < System.currentTimeMillis()){
            throw new LttsAuthException(AuthResultEnum.AUTH_TOKEN_EXPIRED);
        }
        // 续期
        refreshToken(loginUser);
        return loginUser;
    }

    @Override
    public boolean offlineCurrentToken() {
        final String headerToken = ServletUtil.getRequestToken(jwtProperties.getTokenHeaderName());
        if(StrUtil.isNotBlank(headerToken)){
            String token = headerToken.substring(jwtProperties.getTokenPrefix().length());
            forceOfflineToken(token);
        }
        return true;
    }

    @Override
    public boolean forceOfflineToken(String token) {
        String userKey = getTokenKey(token);
        redisService.deleteObject(userKey);
        return true;
    }

    private String getTokenKey(String token){
        return CacheKeys.TOKEN_CACHE_PREFIX_KEY + token;
    }


    @Override
    public boolean isExpired() {
        return false;
    }
}
