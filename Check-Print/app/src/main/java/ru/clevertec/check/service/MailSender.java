package ru.clevertec.check.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSender implements MailService{

    public MailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public void sendEmail(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);         //адрессат
        mailMessage.setSubject(subject);    //тема
        mailMessage.setText(message);       //содержание

        mailSender.send(mailMessage);
    }
}
