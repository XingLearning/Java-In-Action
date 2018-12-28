package com.xing.boot.rocket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketApplicationTest {

    @Autowired
    RocketMQProvider rProvider;

    @Test
    public void testMq() {
        rProvider.defaultMQProducer();
    }
}
