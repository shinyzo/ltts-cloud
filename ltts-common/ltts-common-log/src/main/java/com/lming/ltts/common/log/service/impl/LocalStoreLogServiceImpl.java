package com.lming.ltts.common.log.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.lming.ltts.common.log.config.LogProperties;
import com.lming.ltts.common.log.entity.LogEntity;
import com.lming.ltts.common.log.enums.LogCollectType;
import com.lming.ltts.common.log.service.AsyncLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 15:33
 * Description:
 */
@Service
@EnableAsync
@Slf4j
public class LocalStoreLogServiceImpl implements AsyncLogService {

    @Autowired
    private LogProperties logProperties;


    @Override
    public void saveLog(LogEntity logEntity) {
        localStorageLog(logEntity);
    }


    public void localStorageLog(LogEntity logEntity){


    }
}
