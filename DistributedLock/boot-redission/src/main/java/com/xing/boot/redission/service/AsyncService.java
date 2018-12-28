package com.xing.boot.redission.service;

import com.xing.boot.redission.callback.DistributedLockCallback;
import com.xing.boot.redission.entity.TestEntity;
import com.xing.boot.redission.entity.TestEntityRepository;
import com.xing.boot.redission.template.DistributedLockTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 分布式琐实现类
 *
 * @author weixing
 * @date 2018/12/28 11:47
 */
@Service
public class AsyncService {

    @Resource
    TestEntityRepository ts;

    @Resource
    DistributedLockTemplate distributedLockTemplate;

    /**
     * 加锁
     */
    @Async
    public void addAsync(){
        distributedLockTemplate.lock(new DistributedLockCallback<Object>(){
            @Override
            public Object process() {
                add();
                return null;
            }

            @Override
            public String getLockName() {
                return "MyLock";
            }
        });
    }

    /**
     * 未加锁
     */
    @Async
    public void addNoAsync(){
        add();
    }

    /**
     * 测试异步方法
     * 在不加分布式锁的情况下
     * num数目会混乱
     */
    @Async
    public void add(){
        if(ts.findAll().size()==0){
            TestEntity t  =  new TestEntity();
            t.setNum(1);
            ts.saveAndFlush(t);
        }else{
            TestEntity dbt = ts.findAll().get(0);
            dbt.setNum(dbt.getNum()+1);
            ts.saveAndFlush(dbt);
        }
    }
}
