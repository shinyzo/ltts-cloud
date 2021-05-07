package com.lming.ltts.auth.controller;

import com.lming.ltts.auth.model.LoginForm;
import com.lming.ltts.common.core.response.R;
import com.lming.ltts.common.jwt.annotation.JwtIgnore;
import com.lming.ltts.common.jwt.model.LoginUser;
import com.lming.ltts.common.jwt.service.TokenService;
import com.lming.ltts.common.log.annotation.LttsLog;
import com.lming.ltts.common.redis.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
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



    @ApiOperation(value = "用户认证",notes = "用户认证")
    @GetMapping("/login")
    @LttsLog(title = "用户认证")
    @JwtIgnore
    public R<LoginUser> login(@RequestBody LoginForm loginForm){

        return R.data(null);
    }


}
