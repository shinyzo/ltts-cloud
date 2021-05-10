package com.lming.ltts.common.log.enums;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lming.ltts.common.core.util.SpringContextUtil;
import com.lming.ltts.common.log.handler.*;
import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 16:27
 * Description:
 */
@Getter
public enum LogHandlerType {

    LOCAL_PRINT{
        @Override
        public LogHandler getLogHandler() {
            return SpringContextUtil.getBean(LocalPrintLogHandler.class);
        }
    },

    LOCAL_STORAGE{
        @Override
        public LogHandler getLogHandler() {
            return SpringContextUtil.getBean(LocalStoreLogHandler.class);
        }
    },  // 本地保存，需要本地建立对应表结构
    HTTP_REST{
        @Override
        public LogHandler getLogHandler() {
            return SpringContextUtil.getBean(HttpRestLogHandler.class);
        }
    },  // 远程单机
    FEIGN_CLUSTER{
        @Override
        public LogHandler getLogHandler() {
            return SpringContextUtil.getBean(FeignLogHandler.class);
        }
    }, // 远程集群，需要依赖注册中心获取服务列表

    // 消息队列 暂未实现
    MQ_RABBIT{
        @Override
        public LogHandler getLogHandler() {
            return SpringContextUtil.getBean(RabbitMqLogHandler.class);
        }
    }
    ;

    private LogHandler logHandler;

}
