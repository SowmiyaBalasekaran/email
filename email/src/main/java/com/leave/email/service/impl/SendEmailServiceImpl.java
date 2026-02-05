package com.leave.email.service.impl;

import com.leave.email.service.SendEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String body, String subject, String cc, String bcc) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        if(cc !=null && !cc.isEmpty()) {
            simpleMailMessage.setCc(cc);
        }
        if(bcc !=null && !bcc.isEmpty()) {
            simpleMailMessage.setBcc(bcc);
        }


        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sendEmailWithHtml(String to, String body, String subject, String cc, String bcc) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);

        // 👇 TRUE = HTML content
        mimeMessageHelper.setText(body, true);

        if (cc != null && !cc.isBlank()) {
            mimeMessageHelper.setCc(cc.split(","));
        }

        if (bcc != null && !bcc.isBlank()) {
            mimeMessageHelper.setBcc(bcc.split(","));
        }

        javaMailSender.send(mimeMessage);

    }
}
