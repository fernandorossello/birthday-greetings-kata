package it.xpug.kata.birthday_greetings.domain.exceptions;

public class MessageDeliveryException extends RuntimeException{
    public MessageDeliveryException(Throwable throwable){
        super(throwable);
    }
}
