package com.restep.mq.fanout;

import com.restep.dataobject.UserDO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(UserDO userDO) {
        System.out.println("fanout Receiver C: " + userDO);
    }

}
