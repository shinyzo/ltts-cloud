package com.lming.ltts.common.core.exception;

import com.lming.ltts.common.core.interfaces.IResult;
import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:24
 * Description: 系统异常
 */
@Getter
public class LttsSystemException extends RuntimeException  {

    private Integer code;

    public LttsSystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public LttsSystemException(IResult result) {
        super(result.getMessage());
        this.code = code;
    }
}
