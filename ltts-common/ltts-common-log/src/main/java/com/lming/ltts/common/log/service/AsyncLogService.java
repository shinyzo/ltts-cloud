package com.lming.ltts.common.log.service;

import com.lming.ltts.common.log.entity.LogEntity;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 12:38
 * Description:
 */
public interface AsyncLogService {

    public void saveLog(LogEntity logEntity);

}
