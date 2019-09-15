package com.restep.mq.fanout;

import com.restep.dataobject.UserDO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    @RabbitHandler
    public void process(UserDO userDO) {
        System.out.println("fanout Receiver B: " + userDO);
    }

}
