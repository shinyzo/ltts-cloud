package com.lming.ltts.common.core.aspect;

import com.lming.ltts.common.core.exception.LttsBusinessException;
import com.lming.ltts.common.core.exception.LttsSystemException;
import com.lming.ltts.common.core.exception.LttsValidationException;
import com.lming.ltts.common.core.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 13:44
 * Description:
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(LttsSystemException.class)
    @ResponseBody
    public R handleSystemException(LttsSystemException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(LttsBusinessException.class)
    @ResponseBody
    public R handleBusinessException(LttsBusinessException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(LttsValidationException.class)
    @ResponseBody
    public R handleValidationException(LttsValidationException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }



    @ExceptionHandler(Exception.class)
    public R handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public R validatedBindException(BindException e)
    {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return R.error(message);
    }

}
