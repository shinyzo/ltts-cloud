package com.lming.ltts.log.server.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lming.ltts.api.log.entity.LogRequest;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 12:40
 * Description:
 */
@Data
@ToString
@TableName("`ltts_server_log`")
public class LogEntity extends LogRequest implements Serializable {

    @TableId
    private Long id;

}
