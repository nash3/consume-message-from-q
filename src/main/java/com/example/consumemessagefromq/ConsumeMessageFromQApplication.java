package com.example.consumemessagefromq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class ConsumeMessageFromQApplication {

    @Autowired
    private Queue queue;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ConsumeMessageFromQApplication.class, args);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendToQueue() {
        final Message message = new Message();
        message.setFrom("Jane Doe");
        message.setTo("John Doe");
        message.setMessage("sent to Q");
        this.rabbitTemplate.convertAndSend("messageQ", message);
        log.info("[x] Sent {}", message.toString());
    }
}

