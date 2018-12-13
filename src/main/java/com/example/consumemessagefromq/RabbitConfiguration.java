package com.example.consumemessagefromq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue messageQueue()
    {
        return new Queue("messageQ");
    }

}
