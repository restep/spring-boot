package com.restep.mq.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author restep
 * @date 2019/9/15
 */
@Component
public class NeoSender2 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        String context = "spirng boot neo queue"+" ****** "+i;
        System.out.println("Sender2 : " + context);

        amqpTemplate.convertAndSend("restep", context);
    }
}
