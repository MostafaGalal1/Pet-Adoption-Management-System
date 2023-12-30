package com.adoptapet.adoptapet.Services.NotificationService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class NotificationService {

    private final JavaMailSender mailSender;

    @Autowired
    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAdoptionApplicationEmail(String email) {
        try {
            Notification notification = new Notification();
            notification.setTo(email);
            notification.setSubject("Adoption Application");
            notification.setContent(notification.AdoptionApplicationEmail());
            Send(notification);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private void Send(Notification notification) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(notification.getTo());
        helper.setSubject(notification.getSubject());
        helper.setText(notification.getContent(), true);
        helper.setFrom("AdoptAPetEgy@outlook.com");
        mailSender.send(mimeMessage);
    }
}
