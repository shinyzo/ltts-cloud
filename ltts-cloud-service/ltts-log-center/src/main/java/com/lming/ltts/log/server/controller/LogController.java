package com.lming.ltts.log.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lming.ltts.common.core.response.R;
import com.lming.ltts.log.api.entity.LogRequest;
import com.lming.ltts.log.server.entity.LogEntity;
import com.lming.ltts.log.server.model.LogQuery;
import com.lming.ltts.log.server.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: liangming.zhang
 * Date : 2021/4/25 - 20:08
 * Description:
 */
@RestController
@Api(tags = "日志管理",value = "log api controller")
@RequestMapping("/log")
@Slf4j
public class LogController {


    @Autowired
    private ILogService logService;

    @ApiOperation(value = "日志收集",notes = "日志收集")
    @PostMapping("/collect")
    public R logCollect(@RequestBody LogRequest logRequest){

        log.info("==> 日志收集中心：{}",logRequest);
        LogEntity logEntity = new LogEntity();
        BeanUtils.copyProperties(logRequest,logEntity);
        logService.save(logEntity);
        return R.success();

    }


    @ApiOperation(value = "日志查询",notes = "日志查询")
    @PostMapping("/query")
    public R<Page<LogEntity> > query(LogQuery logQuery){

        return R.data(logService.pageQuery(logQuery));

    }

}
