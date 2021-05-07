package com.lming.ltts.api.log.feign;

import com.lming.ltts.api.log.entity.LogRequest;
import com.lming.ltts.api.log.fallback.RemoteLogFallbackFactory;
import com.lming.ltts.common.core.constants.ServiceConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: liangming.zhang
 * Date : 2021/4/28 - 10:46
 * Description:
 */
@FeignClient(value = ServiceConstants.LOG_SERVICE,fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService {


    @RequestMapping("/log/collect")
    void saveLog(@RequestBody LogRequest logRequest);


}
