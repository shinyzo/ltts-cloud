package com.lming.ltts.order.controller;

import com.lming.ltts.common.core.response.R;
import com.lming.ltts.common.jwt.annotation.JwtIgnore;
import com.lming.ltts.common.jwt.util.JwtTokenUtil;
import com.lming.ltts.common.log.annotation.LttsLog;
import com.lming.ltts.common.redis.service.RedisService;
import com.lming.ltts.order.constants.CacheKeyConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 20:20
 * Description:
 */
@RestController
@Api(tags = "用户管理",value = "user api controller")
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "用户登录",notes = "用户登录")
    @GetMapping("/login")
    @LttsLog(title = "用户认证")
    @JwtIgnore
    public R login(String userName,String password){
        String token = JwtTokenUtil.createJWT("1111",userName,"ADMIN");
        redisService.setCacheObject(CacheKeyConstants.USER_PREFIX_KEY.concat(token),null,30L, TimeUnit.MINUTES);
        return R.data(token);
    }
}
