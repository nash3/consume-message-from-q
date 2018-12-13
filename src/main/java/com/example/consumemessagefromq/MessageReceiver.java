package com.example.consumemessagefromq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "messageQ")
public class MessageReceiver {

    @RabbitHandler
    public void receive(Message message)
    {
        log.info("[v] Received message --- {}", message.toString());
    }

}
