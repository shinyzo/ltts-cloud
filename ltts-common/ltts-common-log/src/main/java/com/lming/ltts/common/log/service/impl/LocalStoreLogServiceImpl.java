package com.lming.ltts.common.log.service.impl;

import com.lming.ltts.common.log.service.AbstractLogService;
import com.lming.ltts.api.log.entity.LogRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 15:33
 * Description:
 */
@Service
@Slf4j
public class LocalStoreLogServiceImpl extends AbstractLogService {


    @Override
    public void saveLog(LogRequest logRequest) {
        localStorageLog(logRequest);
    }


    public void localStorageLog(LogRequest logRequest){

    }
}
