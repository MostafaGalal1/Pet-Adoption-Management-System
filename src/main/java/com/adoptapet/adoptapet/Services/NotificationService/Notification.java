package com.adoptapet.adoptapet.Services.NotificationService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Notification {
    private String to;
    private String subject;
    private String content;

    public String AdoptionApplicationEmail(){
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Arial', sans-serif; }"
                + "  .header { background-color: #242c3c; color: white; padding: 10px; text-align: center; }"
                + "  .content { padding: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='header'>"
                + "    <h2>\uD83C\uDF89 Adoption Application Status Update \uD83C\uDF89</h2>"
                + "  </div>"
                + "  <div class='content'>"
                + "    <p>Dear user,</p>"
                + "    <p>We hope this email finds you well.</p>"
                + "    <p>We would like to inform you of an important update regarding your adoption application status.</p>"
                + "    <p>To access this information, we kindly request you to log in to your account on our website</p>"
                + "    <p>Best regards,</p>"
                + "    <p>The AdoptAPet Team</p>"
                + "  </div>"
                + "</body>"
                + "</html>";
        return htmlContent;
    }
}