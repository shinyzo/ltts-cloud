package com.lming.ltts.common.jwt.interceptor;

import cn.hutool.core.util.StrUtil;
import com.lming.ltts.common.core.exception.LttsAuthException;
import com.lming.ltts.common.jwt.annotation.JwtIgnore;
import com.lming.ltts.common.jwt.config.JwtProperties;
import com.lming.ltts.common.jwt.enums.AuthResultEnum;
import com.lming.ltts.common.jwt.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
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
@Component
public class JwtInterceptor  extends HandlerInterceptorAdapter {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            JwtIgnore jwtIgnore = AnnotationUtils.findAnnotation(handlerMethod.getMethod(),JwtIgnore.class);
            if (jwtIgnore != null) {
                return true;
            }
        }

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        tokenService.parseToken();
        return true;
    }
}
