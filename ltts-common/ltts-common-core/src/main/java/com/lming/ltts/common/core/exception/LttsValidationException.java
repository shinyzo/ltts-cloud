package com.lming.ltts.common.core.exception;

import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 13:31
 * Description: 数据校验异常
 */
@Getter
public class LttsValidationException extends LttsBaseException {

    public LttsValidationException(Integer code, String message) {
        super(code,message);
    }

    public LttsValidationException(String message) {
        super(message);
    }
}
