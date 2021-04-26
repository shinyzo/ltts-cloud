package com.lming.ltts.common.core.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/26 - 10:02
 * Description:
 */
@Data
public class BasePageQuery implements Serializable {

    private Integer current = 1 ;

    private Integer pageSize = 10 ;

}
