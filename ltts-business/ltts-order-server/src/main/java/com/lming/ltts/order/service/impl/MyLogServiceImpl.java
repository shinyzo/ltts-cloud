package com.lming.ltts.order.service.impl;

import com.lming.ltts.common.log.entity.LogEntity;
import com.lming.ltts.common.log.service.AsyncLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/26 - 14:08
 * Description:
 */
@Service
@Slf4j
public class MyLogServiceImpl implements AsyncLogService {

    @Override
    public void saveLog(LogEntity logEntity) {
      log.info("===> my log service :{}",logEntity);
    }
}
