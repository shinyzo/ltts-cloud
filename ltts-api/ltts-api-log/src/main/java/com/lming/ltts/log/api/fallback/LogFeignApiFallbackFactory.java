package com.lming.ltts.log.api.fallback;

import com.lming.ltts.log.api.entity.LogRequest;
import com.lming.ltts.log.api.feign.LogFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/28 - 13:09
 * Description:
 */
@Service
@Slf4j
public class LogFeignApiFallbackFactory implements LogFeignApi {


    @Override
    public void saveLog(LogRequest logRequest) {
        log.error("==> 调用RPC日志保存失败 ");
        return;
    }
}
