package com.lming.ltts.common.log.handler;

import com.lming.ltts.api.log.entity.LogRequest;

/**
 * Author: liangming.zhang
 * Date : 2021/5/10 - 14:12
 * Description:
 */
public interface LogHandler {

    public void handleLog(LogRequest logRequest);

}
