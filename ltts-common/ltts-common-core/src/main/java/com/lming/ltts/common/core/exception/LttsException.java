package com.lming.ltts.common.core.exception;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:24
 * Description:
 */
public class LttsException extends RuntimeException {

    private Integer code;


    public LttsException(Integer code,String message) {
        super(message);
        this.code = code;
    }

}
