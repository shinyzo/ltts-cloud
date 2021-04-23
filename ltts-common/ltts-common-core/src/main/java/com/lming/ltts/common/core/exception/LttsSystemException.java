package com.lming.ltts.common.core.exception;

import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:24
 * Description: 系统异常
 */
@Getter
public class LttsSystemException extends LttsBaseException {

    public LttsSystemException(Integer code, String message) {
        super(code,message);
    }
}
