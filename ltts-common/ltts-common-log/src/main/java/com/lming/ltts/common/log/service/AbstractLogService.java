package com.lming.ltts.common.log.service;

/**
 * Author: liangming.zhang
 * Date : 2021/4/28 - 15:57
 * Description:
 */
public abstract class AbstractLogService implements AsyncLogService {

    @Override
    public boolean isExecute() {
        return true;
    }


}
