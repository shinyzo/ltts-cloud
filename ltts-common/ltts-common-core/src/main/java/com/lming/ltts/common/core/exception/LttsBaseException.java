package com.lming.ltts.common.core.exception;

import com.lming.ltts.common.core.enums.ResultEnum;
import com.lming.ltts.common.core.interfaces.IResult;
import lombok.Data;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 15:29
 * Description:
 */
@Data
public class LttsBaseException extends RuntimeException {


    private Integer code;

    public LttsBaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public LttsBaseException(String message) {
        super(message);
        this.code = ResultEnum.ERROR.getCode();
    }
}
