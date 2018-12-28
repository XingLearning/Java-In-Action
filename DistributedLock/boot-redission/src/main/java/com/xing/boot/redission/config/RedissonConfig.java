package com.xing.boot.redission.config;

import com.xing.boot.redission.factory.DistributedLockFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public DistributedLockFactoryBean distributeLockTemplate(){
        DistributedLockFactoryBean d  = new DistributedLockFactoryBean();
        d.setMode("SINGLE");
        return d;
    }
}
