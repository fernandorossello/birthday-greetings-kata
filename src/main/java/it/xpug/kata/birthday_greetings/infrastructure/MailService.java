package it.xpug.kata.birthday_greetings.infrastructure;

import it.xpug.kata.birthday_greetings.application.INotificationService;

import it.xpug.kata.birthday_greetings.domain.Message;
import it.xpug.kata.birthday_greetings.domain.exceptions.MessageDeliveryException;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService implements INotificationService {

    public static final String MAIL_SMTP_HOST = "mail.smtp.host";
    public static final String MAIL_SMTP_PORT = "mail.smtp.port";
    private final java.util.Properties props = new java.util.Properties();

    public MailService(String smtpHost, int smtpPort)
    {
        props.put(MAIL_SMTP_HOST, smtpHost);
        props.put(MAIL_SMTP_PORT, String.valueOf(smtpPort));
    }

    public void sendMessage(Message message) throws MessageDeliveryException {
        try {
            // Create a mail session
            Session session = Session.getInstance(props, null);

            // Construct the message
            javax.mail.Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(message.getSender()));
            msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(message.getRecipient()));
            msg.setSubject(message.getSubject());
            msg.setText(message.getBody());

            // Send the message
            Transport.send(msg);
        }
        catch (MessagingException exception){
            throw new MessageDeliveryException(exception);
        }
    }
}
