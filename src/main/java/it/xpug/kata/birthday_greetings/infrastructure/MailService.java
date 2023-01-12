package it.xpug.kata.birthday_greetings.infrastructure;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

    public static final String MAIL_SMTP_HOST = "mail.smtp.host";
    public static final String MAIL_SMTP_PORT = "mail.smtp.port";
    private final java.util.Properties props = new java.util.Properties();

    public MailService(String smtpHost, int smtpPort)
    {
        props.put(MAIL_SMTP_HOST, smtpHost);
        props.put(MAIL_SMTP_PORT, String.valueOf(smtpPort));
    }


    public void sendMessage(String sender, String subject, String body, String recipient) throws MessagingException {
        // Create a mail session
        Session session = Session.getInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(sender));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        msg.setSubject(subject);
        msg.setText(body);

        // Send the message
        Transport.send(msg);
    }
}
