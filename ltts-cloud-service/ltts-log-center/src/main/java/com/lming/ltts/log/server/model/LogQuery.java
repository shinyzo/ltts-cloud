package com.lming.ltts.log.server.model;

import com.lming.ltts.common.core.model.BasePageQuery;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/26 - 9:31
 * Description:
 */
@Data
public class LogQuery extends BasePageQuery implements Serializable {

    @ApiModelProperty(name = "serverName",value = "server名称",required = false)
    private String serverName;

    @ApiModelProperty(name = "serverIp",value = "server ip",required = false)
    private String serverIp;

    @ApiModelProperty(name = "moduleName",value = "模块名称",required = false)
    private String moduleName;

    @ApiModelProperty(name = "className",value = "类名",required = false)
    private String className;

    @ApiModelProperty(name = "methodName",value = "方法名称",required = false)
    private String methodName;

    @ApiModelProperty(name = "responseCode",value = "返回码",required = false)
    private Integer responseCode;

    @ApiModelProperty(name = "requestUri",value = "request uri",required = false)
    private String requestUri;

    @ApiModelProperty(name = "logType",value = "日志类型（0：正常，9：异常）",required = false)
    private String logType;

    @ApiModelProperty(name = "inputDate",value = "日期",required = false)
    private String inputDate;

    @ApiModelProperty(name = "costTime",value = ">=耗时",required = false)
    private Long costTime;
}
