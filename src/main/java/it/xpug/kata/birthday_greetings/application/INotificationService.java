package it.xpug.kata.birthday_greetings.application;

import it.xpug.kata.birthday_greetings.domain.Message;

import javax.mail.MessagingException;

public interface INotificationService {
    void sendMessage(Message message ) throws MessagingException;
}
