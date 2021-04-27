package com.lming.ltts.common.log.service.impl;

import cn.hutool.core.util.StrUtil;
import com.lming.ltts.common.log.config.LogProperties;
import com.lming.ltts.common.log.entity.LogEntity;
import com.lming.ltts.common.log.service.AsyncLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 16:39
 * Description:
 */
@Service
@Slf4j
public class RemoteSingleLogServiceImpl implements AsyncLogService {


    @Autowired
    private LogProperties logProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Async
    public void saveLog(LogEntity logEntity) {
        if(StrUtil.isNotEmpty(logProperties.getServerUrl())){
            remoteSingleLogRecord(logEntity,logProperties.getServerUrl());
        }
    }


    private void remoteSingleLogRecord(LogEntity logEntity,String serverUrl) {
        try{
            restTemplate.postForEntity(serverUrl,logEntity,null);
        }catch (Exception e){
            e.printStackTrace();
            log.error("remote rest send log error:{}",e);
        }
    }
}
