package com.lming.ltts.common.core.response;

import com.lming.ltts.common.core.enums.ResultEnum;
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
        return restResult(null, SUCCESS_CODE, null);
    }

    public static <T> R<T> data(T data)
    {
        return restResult(data, SUCCESS_CODE, null);
    }

    public static <T> R<T> success(T data, String msg)
    {
        return restResult(data, SUCCESS_CODE, msg);
    }

    public static <T> R<T> error()
    {
        return restResult(null, FAILED_CODE, null);
    }

    public static <T> R<T> error(String msg)
    {
        return restResult(null, FAILED_CODE, msg);
    }

    public static <T> R<T> error(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    public static <T> R<T> error(T data)
    {
        return restResult(data, FAILED_CODE, null);
    }

    private static <T> R<T> restResult(T data, int code, String msg)
    {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }


}
