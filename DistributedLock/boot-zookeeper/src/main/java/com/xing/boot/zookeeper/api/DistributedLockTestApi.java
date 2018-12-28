package com.xing.boot.zookeeper.api;

import com.xing.boot.zookeeper.lock.DistributedLockByZookeeper;
import com.xing.boot.zookeeper.util.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributedLockTestApi {

    /**
     * The Distributed lock by zookeeper.
     */
    @Autowired
    DistributedLockByZookeeper distributedLockByZookeeper;
    private final static String PATH = "testv3";

    /**
     * Gets lock 1.
     * 获取分布式锁，获取到的期间，其他请求被阻塞，等待上一个释放锁资源
     *
     * @return the lock 1
     */
    @GetMapping("/lock1")
    public ApiResult getLock1() {
        Boolean flag = false;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        if (flag) {
            return ApiResult.prepare().success("释放锁资源成功!");
        }
        return ApiResult.prepare().error(false, 500, "释放锁资源失败");
    }

    /**
     * Gets lock 2.
     * 获取分布式锁，获取到的期间，其他请求被阻塞，等待上一个释放锁资源
     *
     * @return the lock 2
     */
    @GetMapping("/lock2")
    public ApiResult getLock2() {
        Boolean flag;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        if (flag) {
            return ApiResult.prepare().success("释放锁资源成功!");
        }
        return ApiResult.prepare().error(false, 500, "释放锁资源失败");
    }
}
