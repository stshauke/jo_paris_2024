package com.jo_paris_2024.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body, byte[] qrCodeBytes) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, false);

        if (qrCodeBytes != null) {
            helper.addAttachment("QRCode.png", new jakarta.activation.DataSource() {
                public java.io.InputStream getInputStream() throws java.io.IOException {
                    return new java.io.ByteArrayInputStream(qrCodeBytes);
                }

                public java.io.OutputStream getOutputStream() throws java.io.IOException {
                    throw new UnsupportedOperationException("Not supported");
                }

                public String getContentType() {
                    return "image/png";
                }

                public String getName() {
                    return "QRCode.png";
                }
            });
        }

        mailSender.send(message);
    }
}
