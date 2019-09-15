package com.restep.mq.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author restep
 * @date 2019/9/15
 */
@Component
@Slf4j
public class HelloSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + new Date();
        log.info("sender: {}", context);

        amqpTemplate.convertAndSend("hello", context);
    }
}
