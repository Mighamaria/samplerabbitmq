package com.example.springbootRabbitmq.component;

import com.example.springbootRabbitmq.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventConsumer {
    private final EmailService emailService;

    public UserRegisteredEventConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveUserRegisteredEvent(UserRegisteredEvent event) {
        // Handle email notification logic using emailService
        emailService.sendEmail(event.getUser().getEmail(), "Welcome!", "Thank you for registering.");
    }
}
}
