package com.lming.ltts.common.core.response;

import com.lming.ltts.common.core.enums.ResultEnum;
import com.lming.ltts.common.core.interfaces.IResult;
import lombok.*;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/22 - 9:41
 * Description:  Common Response
 */
@Getter
@Setter
@ToString
public class R<T> implements IResult  {

    public static final R SUCCESS = success();
    public static final R ERROR = error();

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 数据域
     */
    private T data;


    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public R(IResult result, T data){
        this.code = result.getCode();
        this.message = result.getMessage();
        this.data = data;
    }

    private static <T> R<T> success() {

        return new R(ResultEnum.SUCCESS,null);

    }

    public static <T> R<T> success(T data) {

        return new R(ResultEnum.SUCCESS,data);

    }

    public static R error() {
        return new R(ResultEnum.ERROR,null);
    }

    public static R error(String message) {
        return new R(ResultEnum.ERROR.getCode(),message,null);
    }

    public static R error(IResult result) {
        return new R(result,null);
    }


    public static R error(Integer code,String message) {
        return new R(code,message,null);
    }



    public int getCode() {
        return this.getCode();
    }

    public String getMessage() {
        return this.getMessage();
    }
}
