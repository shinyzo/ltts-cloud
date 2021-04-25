package com.lming.ltts.common.log.config;

import com.lming.ltts.common.log.entity.RemoteServer;
import com.lming.ltts.common.log.enums.LogCollectType;
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

    private LogCollectType collectType;
    /**
     * 远程服务对象
     */
    private RemoteServer remoteServer;

}