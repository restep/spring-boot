package com.restep.mq.object;

import com.restep.dataobject.UserDO;
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
public class ObjectTest {
    @Autowired
    private ObjectSender sender;

    @Test
    public void sendOject() throws Exception {
        UserDO userDO = new UserDO();
        userDO.setUsername("restep");
        userDO.setPassword("123456");

        sender.send(userDO);
        Thread.sleep(1_000L);
    }
}
