package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.service.EmailRemindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailRemindService")
public class EmailRemindServiceImp implements EmailRemindService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmail(SimpleMailMessage email) {
        mailSender.send(email);
    }
}
