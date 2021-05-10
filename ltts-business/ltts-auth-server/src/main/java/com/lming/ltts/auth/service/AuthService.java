package com.lming.ltts.auth.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.MD5;
import com.lming.ltts.api.upms.entity.SysUser;
import com.lming.ltts.api.upms.enums.UserStatus;
import com.lming.ltts.api.upms.feign.RemoteUserService;
import com.lming.ltts.auth.model.LoginForm;
import com.lming.ltts.common.core.exception.LttsAuthException;
import com.lming.ltts.common.jwt.enums.AuthResultEnum;
import com.lming.ltts.common.jwt.model.LoginUser;
import com.lming.ltts.common.jwt.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/5/7 - 20:34
 * Description:
 */
@Service
public class AuthService {


    @Autowired
    private RemoteUserService remoteUserService;

    @Autowired
    private TokenService tokenService;

    public void logout(){
        tokenService.offlineCurrentToken();
    }


    public LoginUser login(LoginForm loginForm){

        SysUser sysUser = remoteUserService.getUserInfo(loginForm.getLoginName());
        if(ObjectUtil.isEmpty(sysUser)){
            throw new LttsAuthException(AuthResultEnum.AUTH_USER_NOT_EXIST);
        }

        String encMd5Password =  MD5.create().setSalt(sysUser.getSalt().getBytes()).digest(loginForm.getPassword()).toString();
        if(!encMd5Password.equals(sysUser.getPassword())){
            throw new LttsAuthException(AuthResultEnum.AUTH_USER_NOT_EXIST);
        }
        if(UserStatus.NORMAL.getCode() != sysUser.getStatus()){
            throw new LttsAuthException(AuthResultEnum.AUTH_USER_STATUS_ERROR);
        }

        // TODO 加载用户角色以及权限数据

        LoginUser loginUser = BeanUtil.copyProperties(sysUser,LoginUser.class);
        tokenService.createToken(loginUser);
        return loginUser;
    }

}
