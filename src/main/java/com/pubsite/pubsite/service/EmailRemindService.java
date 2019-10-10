package com.pubsite.pubsite.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailRemindService {
    public void sendEmail(SimpleMailMessage email);
}
