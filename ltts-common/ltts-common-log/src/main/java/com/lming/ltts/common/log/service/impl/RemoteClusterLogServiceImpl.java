package com.lming.ltts.common.log.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.lming.ltts.common.log.config.LogProperties;
import com.lming.ltts.common.log.entity.LogEntity;
import com.lming.ltts.common.log.enums.LogCollectType;
import com.lming.ltts.common.log.service.AsyncLogService;
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
public class RemoteClusterLogServiceImpl implements AsyncLogService {

    @Autowired
    private LogProperties logProperties;

    @Override
    public void saveLog(LogEntity logEntity) {
       if(LogCollectType.LOCAL_PRINT == logProperties.getCollectType() &&
               StrUtil.isNotEmpty(logProperties.getRemoteServer().getClusterName())
       ){

          remoteClusterLogRecord(logEntity,logProperties.getRemoteServer().getClusterName());

       }
    }

    private void remoteClusterLogRecord(LogEntity logEntity, String clusterName) {


    }

}
