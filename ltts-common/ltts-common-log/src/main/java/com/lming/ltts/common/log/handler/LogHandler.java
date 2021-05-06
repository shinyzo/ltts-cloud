package com.lming.ltts.common.log.handler;

import com.lming.ltts.common.log.service.AsyncLogService;
import com.lming.ltts.log.api.entity.LogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/5/6 - 14:53
 * Description:
 */
@Service
public class LogHandler {

    @Autowired
    private AsyncLogService asyncLogService;

    @Async
    public void handleLog(LogRequest logRequest){
        if(asyncLogService.isExecute()){
            asyncLogService.saveLog(logRequest);
        }
    }
}
