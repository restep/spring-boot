package com.restep.mq.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author restep
 * @date 2019/9/15
 */
@Component
@RabbitListener(queues = "hello")
@Slf4j
public class HelloReceiver {
    @RabbitHandler
    public void process(String hello) {
        log.info("receiver: {}", hello);
    }
}
