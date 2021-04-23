package com.lming.ltts.common.core.interfaces;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/23 - 13:08
 * Description:
 */
public interface IResult extends Serializable {

    public int getCode();

    public String getMessage();

}
