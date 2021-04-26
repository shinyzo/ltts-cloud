package com.lming.ltts.common.log.enums;

import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 16:27
 * Description:
 */
@Getter
public enum LogCollectType {

    LOCAL_PRINT,    // 本地打印，但不进行日志入库登记
    LOCAL_STORAGE,  // 本地保存，需要本地建立对应表结构
    REMOTE_SINGLE,  // 远程单机
    REMOTE_CLUSTER, // 远程集群，需要依赖注册中心获取服务列表

    // 消息队列 暂未实现
    MQ_RABBIT,
    MQ_KAFKA,
    MQ_ACTIVE,
    MQ_ROCKET,
    ;
}
