package com.lming.ltts.auth.controller;

import com.lming.ltts.auth.model.LoginForm;
import com.lming.ltts.auth.service.AuthService;
import com.lming.ltts.common.core.constants.JwtConstants;
import com.lming.ltts.common.core.response.R;
import com.lming.ltts.common.jwt.annotation.JwtIgnore;
import com.lming.ltts.common.jwt.keys.CacheKeys;
import com.lming.ltts.common.jwt.model.LoginUser;
import com.lming.ltts.common.jwt.service.TokenService;
import com.lming.ltts.common.log.annotation.LttsLog;
import com.lming.ltts.common.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 20:20
 * Description:
 */
@RestController
@Api(tags = "认证中心",value = "Auth Center")
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @Autowired
    private RedisService redisService;


    @PostMapping("/login")
    @ApiOperation(value = "用户认证",notes = "用户认证")
    @LttsLog(title = "用户认证")
    @JwtIgnore
    public R<LoginUser> login(@RequestBody LoginForm loginForm){
        return R.data(authService.login(loginForm));
    }


    @PostMapping("/logout")
    @ApiOperation(value = "用户退出",notes = "用户退出")
    @LttsLog(title = "用户退出")
    @JwtIgnore
    public R logout(){
        authService.logout();
        return R.success();
    }

    @PostMapping("/onlineUsers")
    @ApiOperation(value = "在线用户",notes = "在线用户")
    @LttsLog(title = "在线用户")
    @JwtIgnore
    public R<List<LoginUser>> getAllOnlineUser(){
        List<LoginUser> loginUsers = redisService.getCacheList(CacheKeys.TOKEN_CACHE_PREFIX_KEY+"*");
        return R.data(loginUsers);
    }

}
