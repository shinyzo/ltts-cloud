package com.lming.ltts.common.log.factory;

import cn.hutool.core.util.StrUtil;
import com.lming.ltts.common.core.util.SpringContextUtil;
import com.lming.ltts.common.log.enums.LogHandlerType;
import com.lming.ltts.common.log.handler.LogHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import sun.rmi.runtime.Log;

/**
 * Author: liangming.zhang
 * Date : 2021/5/10 - 14:06
 * Description:
 */
@Slf4j
@Component
public class LogHandlerFactory {

    public LogHandler getHandle(String key){

        LogHandler logHandler = null;
        if(StrUtil.isEmpty(key)){
            return  getDefaultHandle();
        }

        // 系统定义的日志处理器
        logHandler = getSysDefineLogHandle(key);
        if(logHandler != null ) return logHandler;

        // 获取自定义的处理器 通过名称
        logHandler = SpringContextUtil.getBean(key);
        if(logHandler != null ){
            return logHandler;
        }
        log.warn("==> could not found log handle bean:{} ",key);
        log.info("==> set default log handler :{}", LogHandlerType.LOCAL_PRINT.name());
        return getDefaultHandle();
    }


    private LogHandler getSysDefineLogHandle(String handleTypeKey){
        try{
            LogHandlerType logHandlerType = LogHandlerType.valueOf(handleTypeKey.toUpperCase());
            return logHandlerType.getLogHandler();
        }catch (Exception e){
            log.error("{} can not cast to LogHandlerType ",handleTypeKey);
        }

        return null;
    }


    private LogHandler getDefaultHandle() {
        return LogHandlerType.LOCAL_PRINT.getLogHandler();
    }
}
