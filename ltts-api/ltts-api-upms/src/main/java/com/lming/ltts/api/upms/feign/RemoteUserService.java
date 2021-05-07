package com.lming.ltts.api.upms.feign;

import com.lming.ltts.api.upms.entity.SysUser;
import com.lming.ltts.common.core.constants.ServiceConstants;
import com.lming.ltts.common.core.response.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author: liangming.zhang
 * Date : 2021/5/7 - 20:55
 * Description:
 */
@FeignClient(value = ServiceConstants.USER_SERVICE,fallbackFactory = RemoteUserService.class)
public interface RemoteUserService {

    @GetMapping("/user/{userName}")
    public R<SysUser> getUserInfo(@PathVariable String userName);



}
