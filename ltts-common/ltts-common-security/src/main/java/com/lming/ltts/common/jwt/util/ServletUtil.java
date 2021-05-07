package com.lming.ltts.common.jwt.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Author: liangming.zhang
 * Date : 2021/5/7 - 14:26
 * Description:
 */
public class ServletUtil {


    public static String getRequestToken(String tokenName){
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
        String headerToken = servletRequestAttributes.getRequest().getHeader(tokenName);
        return headerToken;
    }
}
