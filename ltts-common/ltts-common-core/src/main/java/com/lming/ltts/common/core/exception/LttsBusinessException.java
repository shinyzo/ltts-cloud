package com.lming.ltts.common.core.exception;

import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:24
 * Description: 业务异常
 */
@Getter
public class LttsBusinessException extends LttsBaseException {

    public LttsBusinessException(Integer code, String message) {
        super(code,message);
    }

    public LttsBusinessException(String message) {
        super(message);
    }
}
