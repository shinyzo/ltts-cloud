package com.lming.ltts.order.handler;

import com.lming.ltts.api.log.entity.LogRequest;
import com.lming.ltts.common.log.handler.AbstractLogHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/5/10 - 16:33
 * Description:
 */
@Slf4j
@Service
public class OrderLogHandler extends AbstractLogHandler {
    @Override
    public void saveLog(LogRequest logRequest) {
        log.info("==> order log handler:{}",logRequest);
    }
}
