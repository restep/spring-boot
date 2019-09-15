package com.restep.mq.object;

import com.restep.dataobject.UserDO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author restep
 * @date 2019/9/15
 */
@Component
public class ObjectSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(UserDO userDO) {
        System.out.println("Sender object: " + userDO.toString());
        this.rabbitTemplate.convertAndSend("object", userDO);
    }
}
