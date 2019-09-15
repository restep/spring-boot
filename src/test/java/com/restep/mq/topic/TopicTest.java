package com.restep.mq.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author restep
 * @date 2019/9/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
    @Autowired
    private TopicSender sender;

    @Test
    public void topic() throws Exception {
        sender.send();
        Thread.sleep(1_000L);
    }

    @Test
    public void topic1() throws Exception {
        sender.send1();
        Thread.sleep(1_000L);
    }

    @Test
    public void topic2() throws Exception {
        sender.send2();
        Thread.sleep(1_000L);
    }
}
