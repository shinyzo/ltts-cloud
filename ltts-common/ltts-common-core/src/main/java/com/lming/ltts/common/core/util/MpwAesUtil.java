package com.lming.ltts.common.core.util;

import com.baomidou.mybatisplus.core.toolkit.AES;

/**
 * Author: liangming.zhang
 * Date : 2021/4/24 - 17:04
 * Description:
 */
public class MpwAesUtil {

    public static void main(String[] args) {
        String randomKey = AES.generateRandomKey();
        System.out.println("==> private key:" + randomKey);
        System.out.println("==> encry password:" + AES.encrypt("123456","8135631e8f67493a"));
    }
}
