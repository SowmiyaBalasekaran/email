package com.leave.email.controller;

import com.leave.email.EmailRequest;
import com.leave.email.service.SendEmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class SendEmailController {

    @Autowired
    private SendEmailService sendEmailService;

    @GetMapping("/send")
    public void sendEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
         sendEmailService.sendEmailWithHtml(emailRequest.getTo(), emailRequest.getBody(), emailRequest.getSubject(), emailRequest.getCC(), emailRequest.getBcc());
    }
}
