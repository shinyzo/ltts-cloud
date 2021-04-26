package com.lming.ltts.log.server.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lming.ltts.log.server.entity.LogEntity;
import com.lming.ltts.log.server.model.LogQuery;

/**
 * Author: liangming.zhang
 * Date : 2021/4/26 - 9:04
 * Description:
 */
public interface ILogService extends IService<LogEntity> {


    Page<LogEntity> pageQuery(LogQuery logQuery);


}
