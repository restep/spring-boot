package com.restep.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author restep
 * @date 2019/9/15
 */
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue neoQueue() {
        return new Queue("restep");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }
}
