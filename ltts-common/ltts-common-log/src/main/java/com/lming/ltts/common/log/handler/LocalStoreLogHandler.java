package com.lming.ltts.common.log.handler;

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
public class LocalStoreLogHandler extends AbstractLogHandler {


    @Override
    @Async
    public void saveLog(LogRequest logRequest) {

        log.info("==> local store:{}",logRequest);
    }


}
