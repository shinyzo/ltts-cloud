package com.lming.ltts.common.log.entity;

import lombok.Data;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 15:26
 * Description:
 */
@Data
public class RemoteServer {

    /**
     * log-center在集群中的名称
     */
    private String clusterName;

    /**
     * 单机模式下 通过url请求发送数据
     */
    // http://xxxx:port/log-center/log/collect
    private String serverUrl;

}
