package com.lming.ltts.common.jwt.enums;

import com.lming.ltts.common.core.interfaces.IResult;
import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 16:41
 * Description:
 */
@Getter
public enum  AuthResultEnum implements IResult {


    AUTH_TOKEN_EXPIRED(901,"token expired"),
    AUTH_TOKEN_INVALID(902,"token invalid"),
    AUTH_SIGNATURE_ERROR(903,"token signature error"),
    AUTH_TOKEN_EMPTY(904,"token empty"),
    ;

    private Integer code;

    private String message;

    AuthResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
