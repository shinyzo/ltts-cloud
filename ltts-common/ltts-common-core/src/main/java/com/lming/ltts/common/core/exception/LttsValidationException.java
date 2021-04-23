package com.lming.ltts.common.core.exception;

import com.lming.ltts.common.core.interfaces.IResult;
import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 13:31
 * Description: 数据校验异常
 */
@Getter
public class LttsValidationException extends RuntimeException {

    private Integer code;

    public LttsValidationException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public LttsValidationException(IResult result) {
        super(result.getMessage());
        this.code = code;
    }
}
