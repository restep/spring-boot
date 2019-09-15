package com.restep.mq.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author restep
 * @date 2019/9/15
 */
@Component
@RabbitListener(queues = "restep")
public class NeoReceiver1 {
    @RabbitHandler
    public void process(String neo) {
        System.out.println("Receiver 1: " + neo);
    }
}
