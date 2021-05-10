package com.lming.ltts.common.log.handler;

import cn.hutool.core.util.StrUtil;
import com.lming.ltts.api.log.entity.LogRequest;
import com.lming.ltts.common.log.config.LogProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Author: liangming.zhang
 * Date : 2021/5/10 - 14:14
 * Description:
 */
@Service
@Slf4j
public class HttpRestLogHandler extends AbstractLogHandler {

    @Autowired
    private LogProperties logProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean isExecute() {
        if(StrUtil.isEmpty(logProperties.getServerUrl())){
            log.warn("log center serverUrl is empty.");
            return false;
        }
        return true;
    }

    @Override
    @Async
    public void saveLog(LogRequest logRequest) {
        try{
            restTemplate.postForEntity(logProperties.getServerUrl(),logRequest,null);
        }catch (Exception e){
            log.error("http rest send log error:{}",e.getMessage());
        }
    }
}
