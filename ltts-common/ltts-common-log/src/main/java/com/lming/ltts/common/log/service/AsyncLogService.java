package com.lming.ltts.common.log.service;

import com.lming.ltts.api.log.entity.LogRequest;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 12:38
 * Description:
 */
public interface AsyncLogService {

    public boolean isExecute();

    public void saveLog(LogRequest logRequest);

}
