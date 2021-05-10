package com.lming.ltts.common.log.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 15:22
 * Description:
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "ltts.log")
public class LogProperties {
    /**
     * 是否启用
     */
    private Boolean enabled;
    /**
     * 日志处理器
     */
    private String handleType;
    /**
     * 集群时，集群名称
     */
    private String clusterName;
    /**
     * 服务端日志收集的url
     */
    private String serverUrl;

}
