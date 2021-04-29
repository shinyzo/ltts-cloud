package com.lming.ltts.common.log.service.impl;

import cn.hutool.json.JSONUtil;
import com.lming.ltts.common.log.service.AsyncLogService;
import com.lming.ltts.log.api.entity.LogRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 15:33
 * Description:
 */
@Service
@Slf4j
public class RabbitMqLogServiceImpl implements AsyncLogService {

    @Override
    public boolean isExecute() {
        return false;
    }

    @Override
    public void saveLog(LogRequest logRequest) {
        log.info("==> send log to mq :{}" , JSONUtil.toJsonStr(logRequest));
    }

}
