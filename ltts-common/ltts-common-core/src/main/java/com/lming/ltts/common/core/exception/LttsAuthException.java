package com.lming.ltts.common.core.exception;

import com.lming.ltts.common.core.interfaces.IResult;
import lombok.Getter;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:24
 * Description: 系统异常
 */
@Getter
public class LttsAuthException extends LttsBaseException {

    public LttsAuthException(Integer code, String message) {
        super(code,message);
    }

    public LttsAuthException(String message) {
        super(message);
    }

    public LttsAuthException(IResult result) {
        super(result);
    }

}
