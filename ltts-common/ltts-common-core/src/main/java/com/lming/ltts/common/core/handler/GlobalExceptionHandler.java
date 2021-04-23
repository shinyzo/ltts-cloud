package com.lming.ltts.common.core.handler;

import com.lming.ltts.common.core.enums.ResultEnum;
import com.lming.ltts.common.core.exception.LttsBaseException;
import com.lming.ltts.common.core.exception.LttsBusinessException;
import com.lming.ltts.common.core.exception.LttsSystemException;
import com.lming.ltts.common.core.exception.LttsValidationException;
import com.lming.ltts.common.core.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLSyntaxErrorException;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 13:44
 * Description:
 */
@RestControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(LttsSystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleSystemException(LttsSystemException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(LttsBusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public R handleBusinessException(LttsBusinessException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(LttsValidationException.class)
    @ResponseStatus(HttpStatus.OK)
    public R handleValidationException(LttsValidationException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public R validatedBindException(BindException e)
    {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return R.error(message);
    }

    @ExceptionHandler(LttsBaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R baseExceptionHandler(LttsBaseException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R badSqlGrammarExceptionHandler(BadSqlGrammarException e) {
        log.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }

}
