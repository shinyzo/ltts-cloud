package com.lming.ltts.common.log.handler;

import cn.hutool.json.JSONUtil;
import com.lming.ltts.api.log.entity.LogRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 15:33
 * Description:
 */
@Service
@Slf4j
public class RabbitMqLogHandler extends AbstractLogHandler {

    @Override
    public boolean isExecute() {
        return false;
    }

    @Override
    @Async
    public void saveLog(LogRequest logRequest) {

        log.info("==> send log to mq :{}" , JSONUtil.toJsonStr(logRequest));
    }

}
