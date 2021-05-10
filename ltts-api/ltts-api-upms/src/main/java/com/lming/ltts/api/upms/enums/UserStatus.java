package com.lming.ltts.api.upms.enums;

import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/5/8 - 21:04
 * Description:
 */
@Getter
public enum UserStatus {

    NORMAL(0,"正常"),
    LOCK(9,"锁定"),

    ;

    private int code;

    private String message;

    UserStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
