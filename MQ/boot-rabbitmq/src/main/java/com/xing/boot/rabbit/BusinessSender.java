package com.xing.boot.rabbit;

import com.xing.boot.rabbit.entity.MqUser;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者
 *
 * @author weixing
 * @date 2018/12/28 16:16
 */
@Component
public class BusinessSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(MqUser mqUser) {
        System.out.println("Sender : " + mqUser.toString());
        this.rabbitTemplate.convertAndSend("xing", mqUser);
    }
}
