package com.xing.boot.rabbit;

import com.xing.boot.rabbit.entity.MqUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类
 *
 * @author yangweixing
 * @date 2018-12-6 10:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitApplicationTest {

    @Autowired
    private RabbitMQProvider rProvider;

    @Test
    public void xing() {
        for (int i = 0; i < 1000; i++) {
            MqUser mqUser = new MqUser();
            mqUser.setUsername("um"+i);
            mqUser.setPassword("pw"+i);
            mqUser.setEamil(i+"@126.com");
            rProvider.send(mqUser);
        }
    }
}
