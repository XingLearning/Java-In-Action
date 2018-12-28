package com.xing.boot.zookeeper.config;
import com.xing.boot.zookeeper.lock.DistributedLockByZookeeper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 *
 * @author weixing
 * @date 2018/12/28 12:45
 */
@Configuration
public class SpringConfiguration {

    /**
     * Distributed lock by zookeeper distributed lock by zookeeper.
     *
     * @return the distributed lock by zookeeper
     */
    @Bean(initMethod = "init")
    public DistributedLockByZookeeper distributedLockByZookeeper() {
        return new DistributedLockByZookeeper();
    }
}
