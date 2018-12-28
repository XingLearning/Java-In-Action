package com.xing.boot.redission.template;

import com.xing.boot.redission.callback.DistributedLockCallback;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁操作模板
 *
 * @author weixing
 * @date 2018/12/28 10:22
 */
public interface DistributedLockTemplate {

    /**
     * 使用分布式锁，使用锁默认超时时间。
     *
     * @param callback
     * @return T
     */
    public <T> T lock(DistributedLockCallback<T> callback);

    /**
     * 使用分布式锁。自定义锁的超时时间
     *
     * @param callback
     * @param leaseTime 锁超时时间。超时后自动释放锁。
     * @param timeUnit
     * @return T
     */
    public <T> T lock(DistributedLockCallback<T> callback, long leaseTime, TimeUnit timeUnit);
}
