package com.lming.ltts.common.log.handler;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.lming.ltts.common.log.config.LogProperties;
import com.lming.ltts.api.log.entity.LogRequest;
import com.lming.ltts.api.log.feign.RemoteLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 15:33
 * Description:
 */
@Service
@Slf4j
public class FeignLogHandler extends AbstractLogHandler {

    @Autowired
    private RemoteLogService remoteLogService;

    @Autowired
    private LogProperties logProperties;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public boolean isExecute() {

        if(StrUtil.isEmpty(logProperties.getClusterName())){
            log.error("log center cluster name is empty.");
            return false;
        }
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(logProperties.getClusterName());
        if(CollectionUtil.isEmpty(serviceInstanceList)){
            log.warn("no available server can use ,server name:{}",logProperties.getClusterName());
            return false;
        }
        return true;
    }

    @Override
    @Async
    public void saveLog(LogRequest logRequest) {
        remoteLogService.saveLog(logRequest);
    }

}
