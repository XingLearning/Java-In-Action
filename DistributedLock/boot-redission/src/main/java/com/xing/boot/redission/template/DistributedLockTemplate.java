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
     * @param callback 回调
     * @return T
     */
    <T> T lock(DistributedLockCallback<T> callback);

    /**
     * 使用分布式锁。自定义锁的超时时间
     *
     * @param callback 回调
     * @param leaseTime 锁超时时间。超时后自动释放锁。
     * @param timeUnit 超市单位
     * @return T
     */
    <T> T lock(DistributedLockCallback<T> callback, long leaseTime, TimeUnit timeUnit);
}
