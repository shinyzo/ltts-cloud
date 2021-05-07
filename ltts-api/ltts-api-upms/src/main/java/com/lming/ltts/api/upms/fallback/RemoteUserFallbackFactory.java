package com.lming.ltts.api.upms.fallback;

import com.lming.ltts.api.upms.entity.SysUser;
import com.lming.ltts.api.upms.feign.RemoteUserService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/28 - 13:09
 * Description:
 */
@Service
@Slf4j
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {


    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public SysUser getUserInfo(String userName) {
                log.error("==> 获取用户信息失败:{}",userName);
                return null;
            }
        };
    }
}
