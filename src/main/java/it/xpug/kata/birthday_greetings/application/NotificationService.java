package it.xpug.kata.birthday_greetings.application;

import it.xpug.kata.birthday_greetings.domain.Message;
import it.xpug.kata.birthday_greetings.domain.exceptions.MessageDeliveryException;

public interface NotificationService {
    void sendMessage(Message message) throws MessageDeliveryException;
}
