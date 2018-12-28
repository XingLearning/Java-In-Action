package com.xing.boot.redission.callback;

/**
 * 分布式锁回调接口
 *
 * @author weixing
 * @date 2018/12/28 10:21
 */
public interface  DistributedLockCallback<T> {

    /**
     * 调用者必须在此方法中实现需要加分布式锁的业务逻辑
     *
     * @return T
     */
    public T process();

    /**
     * 得到分布式锁名称
     *
     * @return String
     */
    public String getLockName();
}
