package com.leave.email.service;

import jakarta.mail.MessagingException;

public interface SendEmailService {
    public void sendEmail(String to, String body, String subject, String cc, String bcc);

    public void sendEmailWithHtml(String to, String body, String subject, String cc, String bcc) throws MessagingException;
}
