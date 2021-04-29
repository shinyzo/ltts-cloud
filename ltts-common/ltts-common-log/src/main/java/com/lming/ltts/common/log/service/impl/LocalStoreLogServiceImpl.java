package com.lming.ltts.common.log.service.impl;

import com.lming.ltts.common.log.config.LogProperties;
import com.lming.ltts.common.log.service.AsyncLogService;
import com.lming.ltts.log.api.entity.LogRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 15:33
 * Description:
 */
@Service
@Slf4j
public class LocalStoreLogServiceImpl implements AsyncLogService {


    @Override
    public boolean isExecute() {
        return true;
    }

    @Override
    public void saveLog(LogRequest logRequest) {
        localStorageLog(logRequest);
    }


    public void localStorageLog(LogRequest logRequest){

    }
}
