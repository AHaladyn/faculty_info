package com.pubsite.pubsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfig {

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setProtocol("SMTP");
        javaMailSender.setHost("127.0.0.1");
        javaMailSender.setPort(587);

        return javaMailSender;
    }
}
