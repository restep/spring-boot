package com.restep.mq.many;

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
public class ManyTest {
    @Autowired
    private NeoSender1 neoSender1;

    @Autowired
    private NeoSender2 neoSender2;

    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            neoSender1.send(i);
        }

        Thread.sleep(10_000L);
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            neoSender1.send(i);
            neoSender2.send(i);
        }

        Thread.sleep(10_000L);
    }
}
