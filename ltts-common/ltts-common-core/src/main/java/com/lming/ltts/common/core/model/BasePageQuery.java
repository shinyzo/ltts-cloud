package com.lming.ltts.common.core.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

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
