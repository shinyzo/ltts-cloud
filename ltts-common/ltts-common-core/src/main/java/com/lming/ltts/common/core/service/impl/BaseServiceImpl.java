package com.lming.ltts.common.core.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lming.ltts.common.core.service.BaseService;

/**
 * Author: liangming.zhang
 * Date : 2021/4/20 - 10:27
 * Description:
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T>  extends ServiceImpl<M,T> implements BaseService<T> {




}
