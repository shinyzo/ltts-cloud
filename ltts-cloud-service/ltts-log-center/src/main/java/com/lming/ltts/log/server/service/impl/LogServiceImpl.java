package com.lming.ltts.log.server.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lming.ltts.log.server.entity.LogEntity;
import com.lming.ltts.log.server.mapper.LogMapper;
import com.lming.ltts.log.server.model.LogQuery;
import com.lming.ltts.log.server.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/26 - 9:05
 * Description:
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogEntity> implements ILogService {

    @Autowired
    private LogMapper logMapper;



    @Override
    public Page<LogEntity> pageQuery(LogQuery logQuery) {
        Page page = new Page(logQuery.getCurrent(),logQuery.getPageSize());

        LambdaQueryWrapper<LogEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        if(StrUtil.isNotEmpty(logQuery.getServerName())){
            lambdaQueryWrapper.like(LogEntity::getServerName,logQuery.getServerName());
        }

        if(StrUtil.isNotEmpty(logQuery.getServerIp())){
            lambdaQueryWrapper.like(LogEntity::getServerIp,logQuery.getServerIp());
        }

        if(StrUtil.isNotEmpty(logQuery.getClassName())){
            lambdaQueryWrapper.like(LogEntity::getClassName,logQuery.getClassName());
        }

        if(StrUtil.isNotEmpty(logQuery.getMethodName())){
            lambdaQueryWrapper.like(LogEntity::getMethodName,logQuery.getMethodName());
        }

        if(StrUtil.isNotEmpty(logQuery.getInputDate())){
            lambdaQueryWrapper.eq(LogEntity::getCreateDate,logQuery.getInputDate());
        }

        if(StrUtil.isNotEmpty(logQuery.getRequestUri())){
            lambdaQueryWrapper.like(LogEntity::getRequestUri,logQuery.getRequestUri());
        }

        if(logQuery.getCostTime() !=null){
            lambdaQueryWrapper.lt(LogEntity::getCostTime,logQuery.getCostTime());
        }

        if(logQuery.getResponseCode() !=null){
            lambdaQueryWrapper.eq(LogEntity::getResponseCode,logQuery.getResponseCode());
        }

        if(StrUtil.isNotEmpty(logQuery.getLogType())){
            lambdaQueryWrapper.eq(LogEntity::getLogType,logQuery.getLogType());
        }

       return logMapper.selectPage(page,lambdaQueryWrapper);
    }
}
