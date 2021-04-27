package com.lming.ltts.common.log.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lming.ltts.common.mybatis.entity.BaseIdEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 12:40
 * Description:
 */
@Data
@ToString
@TableName("ltts_log_record")
public class LogEntity extends BaseIdEntity implements Serializable {

    /**
     * 服务端系统名称
     */
    private String serverName;
    /**
     * 服务端ip
     */
    private String serverIp;
    /**
     * 客户端ip
     */
    private String clientIp;
    /**
     * 客户端url
     */
    private String requestUri;
    /**
     * 浏览器类型
     */
    private String userAgent;
    /**
     * 请求方式
     */
    private String methodType;
    /**
     * className
     */
    private String className;
    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 日志名称
     */
    private String logName;
    /**
     * 日志类型
     */
    private String logType;
    /**
     * 请求参数
     */
    private String requestData;
    /**
     * 响应数据
     */
    private String responseData;
    /**
     * 返回码
     */
    private Integer responseCode;
    /**
     * 返回消息
     */
    private String errorMsg;
    /**
     * 请求耗时
     */
    private Long costTime;
    /**
     *  请求日期(年月日)
     */
    private Date createDate;
    /**
     * 时间戳
     */
    private Date timestamp;
}
