package com.lming.ltts.common.core.response;

import com.lming.ltts.common.core.enums.ResultEnum;
import com.lming.ltts.common.core.interfaces.IResult;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author liangming.zhang
 */
@Data
public class R<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int SUCCESS_CODE = ResultEnum.SUCCESS.getCode();

    /** 失败 */
    public static final int FAILED_CODE = ResultEnum.ERROR.getCode();

    public static final R SUCCESS = success();

    public static final R ERROR = error();

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> success()
    {
        return restResult(ResultEnum.SUCCESS, null);
    }

    public static <T> R<T> data(T data)
    {
        return restResult(ResultEnum.SUCCESS, data);
    }

    public static <T> R<T> error()
    {
        return restResult( ResultEnum.ERROR, null);
    }

    public static <T> R<T> error(String msg)
    {
        return restResult(FAILED_CODE,  msg ,null);
    }

    public static <T> R<T> error(int code, String msg)
    {
        return restResult(code, msg, null);
    }

    public static <T> R<T> error(T data)
    {
        return restResult( ResultEnum.ERROR , data);
    }



    private static <T> R<T> restResult(IResult result, T data)
    {
        return restResult(result.getCode(), result.getMessage(), data);
    }

    private static <T> R<T> restResult(int code, String msg,T data)
    {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }


}
