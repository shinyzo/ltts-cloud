package com.lming.ltts.common.core.enums;

import com.lming.ltts.common.core.interfaces.IResult;
import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 13:09
 * Description:
 */
public enum ResultEnum implements IResult {

    SUCCESS(200,"OK"),
    ERROR(500,"Failed"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
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
