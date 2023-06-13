package com.example.springbootRabbitmq.component;

import lombok.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;
    private final String routingKey;

    public UserRegisteredEventProducer(RabbitTemplate rabbitTemplate,
                                       @Value("${rabbitmq.exchange}") String exchangeName,
                                       @Value("${rabbitmq.routingKey}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }

    public void sendUserRegisteredEvent(UserRegisteredEvent event) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, event);
    }
}
}
