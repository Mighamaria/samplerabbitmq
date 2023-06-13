package com.example.springbootRabbitmq.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailServiceProvider emailServiceProvider;

    public EmailService(EmailServiceProvider emailServiceProvider) {
        this.emailServiceProvider = emailServiceProvider;
    }

    public void sendEmail(String recipient, String subject, String body) {
        // Call the email service provider's API or utilize SMTP protocols to send the email
        emailServiceProvider.sendEmail(recipient, subject, body);
    }
}

