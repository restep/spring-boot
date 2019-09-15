package com.restep.mq.fanout;

import com.restep.dataobject.UserDO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author restep
 * @date 2019/9/15
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        UserDO userDO = new UserDO();
        userDO.setUsername("Fanout");
        userDO.setPassword("123456");
        this.rabbitTemplate.convertAndSend("fanoutExchange","", userDO);
    }
}
