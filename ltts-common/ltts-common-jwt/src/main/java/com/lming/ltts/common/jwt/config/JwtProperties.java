package com.lming.ltts.common.jwt.config;

import com.lming.ltts.common.core.constants.JwtConstants;
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
    private boolean enabled = true;

    /**
     * 需要授权认证的urls
     */
    private List<String> authUrls;
    /**
     * 忽略的urls
     */
    private List<String> ignoreUrls;
    /**
     * client_id
     */
    private String clientId = "098f6bcd4621d373cade4e832627b4f6";
    /**
     * base64私钥
     */
    private String base64Secret ="MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
    /**
     *
     */
    private String name;
    /**
     * 过期毫秒数
     */
    private Long expiresSecond = 1000 * 60 * 30L;
    /**
     * 前端token前缀
     */
    private String tokenPrefix = JwtConstants.DEFAULT_TOKEN_VALUE_PREFIX;
    /**
     * hader中的token参数名称
     */
    private String tokenHeaderName = JwtConstants.DEFAULT_TOKEN_HEADER_NAME;
}
