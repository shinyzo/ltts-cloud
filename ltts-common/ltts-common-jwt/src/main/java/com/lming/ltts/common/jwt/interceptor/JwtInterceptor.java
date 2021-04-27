package com.lming.ltts.common.jwt.interceptor;

import cn.hutool.core.util.StrUtil;
import com.lming.ltts.common.core.exception.LttsAuthException;
import com.lming.ltts.common.jwt.annotation.JwtIgnore;
import com.lming.ltts.common.jwt.config.JwtProperties;
import com.lming.ltts.common.jwt.constants.JwtConstants;
import com.lming.ltts.common.jwt.enums.AuthResultEnum;
import com.lming.ltts.common.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 16:51
 * Description:
 */
@Slf4j
public class JwtInterceptor  extends HandlerInterceptorAdapter {

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }
        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        // 获取请求头信息authorization信息
        final String authHeader = request.getHeader(JwtConstants.AUTH_HEADER_KEY);
        log.info("## authHeader= {}", authHeader);
        log.info("## Request URL ={}", request.getRequestURL());
        if (StrUtil.isBlank(authHeader) || !authHeader.startsWith(JwtConstants.TOKEN_PREFIX)) {
            log.warn("### 用户未登录，请先登录 ###");
            throw new LttsAuthException(AuthResultEnum.USER_NOT_LOGGED_IN);
        }
        // 获取token
        final String token = authHeader.substring(JwtConstants.TOKEN_PREFIX.length());
        JwtTokenUtil.parseJWT(token, jwtProperties.getBase64Secret());
        return true;
    }
}
