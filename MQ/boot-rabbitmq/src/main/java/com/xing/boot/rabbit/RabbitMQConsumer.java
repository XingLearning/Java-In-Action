package com.xing.boot.rabbit;

import com.xing.boot.rabbit.entity.MqUser;
import com.xing.boot.rabbit.entity.MqUserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消费者
 *
 * @author weixing
 * @date 2018/12/28 16:16
 */
@Component
@RabbitListener(queues = "xing")
public class RabbitMQConsumer {

    @Resource
    MqUserRepository mu;

    @RabbitHandler
    public void process(MqUser mqUser) {
        mu.save(mqUser);
        System.out.println("Receiver : " + mqUser.toString());
    }
}