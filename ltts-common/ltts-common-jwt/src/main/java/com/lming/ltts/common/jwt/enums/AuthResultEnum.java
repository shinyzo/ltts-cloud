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


    AUTH_TOKEN_EXPIRED(901,"PERMISSION_TOKEN_EXPIRED"),
    AUTH_TOKEN_INVALID(902,"PERMISSION_TOKEN_INVALID"),
    AUTH_SIGNATURE_ERROR(903,"PERMISSION_SIGNATURE_ERROR"),
    USER_NOT_LOGGED_IN(904,"USER_NOT_LOGGED_IN"),
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
