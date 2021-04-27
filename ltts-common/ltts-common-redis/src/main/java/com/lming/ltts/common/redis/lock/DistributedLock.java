package com.lming.ltts.common.redis.lock;

/**
 * Author: liangming.zhang
 * Date : 2021/4/27 - 11:14
 * Description:
 */
public interface DistributedLock {

    /**
     * 默认超时时间
     */
    public static final long TIMEOUT_MILLIS = 30000;
    /**
     * 重试获取锁次数
     */
    public static final int RETRY_TIMES = 10;

    /**
     * 休眠时间，没获取到锁，等待500ms
     */
    public static final long SLEEP_MILLIS = 500;

    public boolean lock(String key);

    public boolean lock(String key, int retryTimes);

    public boolean lock(String key, int retryTimes, long sleepMillis);

    public boolean lock(String key, long expire);

    public boolean lock(String key, long expire, int retryTimes);

    public boolean lock(String key, long expire, int retryTimes, long sleepMillis);

    public boolean releaseLock(String key);
}
