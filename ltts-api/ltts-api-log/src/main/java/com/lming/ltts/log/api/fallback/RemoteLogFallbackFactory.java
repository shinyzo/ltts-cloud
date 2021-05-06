package com.lming.ltts.log.api.fallback;

import com.lming.ltts.log.api.entity.LogRequest;
import com.lming.ltts.log.api.feign.RemoteLogService;
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
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {

    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService() {
            @Override
            public void saveLog(LogRequest logRequest) {
                log.error("==> 保存日志失败");
                return ;
            }
        };

    }
}
