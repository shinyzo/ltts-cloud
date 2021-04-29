package com.lming.ltts.common.log.service.impl;

import cn.hutool.core.util.StrUtil;
import com.lming.ltts.common.log.config.LogProperties;
import com.lming.ltts.common.log.service.AbstractLogService;
import com.lming.ltts.common.log.service.AsyncLogService;
import com.lming.ltts.log.api.entity.LogRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 16:39
 * Description:
 */
@Service
@Slf4j
public class HttpClientLogServiceImpl extends AbstractLogService {

    @Autowired
    private LogProperties logProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean isExecute() {

        if(StrUtil.isEmpty(logProperties.getServerUrl())){
            log.warn("log properties serverUrl is empty.");
            return false;
        }

        return true;
    }

    @Override
    public void saveLog(LogRequest logEntity) {
        if(isExecute()) saveLog(logEntity,logProperties.getServerUrl());
    }


    public void saveLog(LogRequest logRequest,String serverUrl){
        try{
            restTemplate.postForEntity(serverUrl,logRequest,null);
        }catch (Exception e){
            log.error("remote rest send log error:{}",e.getMessage());
        }
    }

}
