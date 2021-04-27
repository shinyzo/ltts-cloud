package com.lming.ltts.common.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 13:25
 * Description:
 */
@Data
@ConfigurationProperties(prefix = "ltts.jwt")
public class JwtProperties {

    /**
     * 是否启用jwt认证
     */
    private boolean enabled;

    /**
     * 需要授权认证的urls
     */
    private List<String> authUrls;
    /**
     * 忽略的urls
     */
    private List<String> ignoreUrls;

    private String clientId;

    private String base64Secret;

    private String name;

    private int expiresSecond;
}
