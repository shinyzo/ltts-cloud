package com.lming.ltts.common.log.handler;

import com.lming.ltts.api.log.entity.LogRequest;

/**
 * Author: liangming.zhang
 * Date : 2021/5/10 - 14:12
 * Description:
 */
public abstract class AbstractLogHandler implements LogHandler {


    public boolean isExecute(){
        return true;
    };

    @Override
    public void handleLog(LogRequest logRequest){
        if(isExecute()) saveLog(logRequest);
    }

    public abstract void saveLog(LogRequest logRequest);
}
