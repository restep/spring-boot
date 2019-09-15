package com.restep.mq.object;

import com.restep.dataobject.UserDO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author restep
 * @date 2019/9/15
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {
    @RabbitHandler
    public void process(UserDO userDO) {
        System.out.println("Receiver object : " + userDO);
    }
}
