package com.lming.ltts.common.log.util;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.lming.ltts.common.core.enums.ResultEnum;
import com.lming.ltts.common.log.enums.LogType;
import com.lming.ltts.log.api.entity.LogRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Date;
import java.util.Objects;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 13:12
 * Description:
 */
public class LogUtil {



    public static LogRequest buildLogEntity() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        LogRequest logEntity = new LogRequest();

        logEntity.setServerIp(getServerIp());

        logEntity.setLogType(LogType.NORMAL.getType());
        logEntity.setClientIp(ServletUtil.getClientIP(request));
        logEntity.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        logEntity.setMethodType(request.getMethod());
        logEntity.setUserAgent(request.getHeader("user-agent"));
        logEntity.setRequestData(HttpUtil.toParams(request.getParameterMap()));

        Date date = new Date();
        logEntity.setCreateDate(date);
        logEntity.setTimestamp(date);

        logEntity.setResponseCode(ResultEnum.SUCCESS.getCode());
        logEntity.setErrorMsg(ResultEnum.SUCCESS.getMessage());

        return logEntity;
    }


    /**
     * @return
     * 获取当前机器的IP
     */
    public static String getServerIp() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }


        byte[] ipAddr = addr.getAddress();
        String ipAddrStr = "";
        for (int i = 0; i < ipAddr.length; i++) {
            if (i > 0) {
                ipAddrStr += ".";
            }
            ipAddrStr += ipAddr[i] & 0xFF;
        }
        return ipAddrStr;
    }


}
