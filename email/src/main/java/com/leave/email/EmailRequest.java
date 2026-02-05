package com.leave.email;

import lombok.Data;

@Data
public class EmailRequest {

    private String to;
    private String subject;
    private String body;
    private String cc;
    private String bcc;

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getCC() { return cc; }
    public void setCC(String email) { this.cc = cc; }

    public String getBcc() { return bcc; }
    public void setBcc(String email) { this.bcc = bcc; }
}
