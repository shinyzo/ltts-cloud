package com.lming.ltts.order.controller;

import com.lming.ltts.common.core.response.R;
import com.lming.ltts.common.log.annotation.LttsLog;
import com.lming.ltts.common.log.entity.LogEntity;
import com.lming.ltts.order.entity.OrderEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 16:08
 * Description:
 */
@RestController
@Api(tags = "日志管理",value = "log api controller")
@Slf4j
public class LogController {

    @ApiOperation(value = "日志收集",notes = "日志收集")
    @PostMapping("/log/collect")
    public R logCollect(@RequestBody LogEntity logEntity){

        log.info("==> 日志收集中心：{}",logEntity);
        return R.success();

    }
}
