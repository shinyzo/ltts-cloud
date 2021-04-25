package com.lming.ltts.common.log.enums;


import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/22 - 9:53
 * Description:
 */
@Getter
public enum LogType {

    NORMAL("0","正常日志"),
    LOGIN("1", "登录日志"),
    LOGOUT("2","退出日志"),
    ERROR("9","错误日志"),
    ;

    private String type;

    private String message;

    LogType(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
