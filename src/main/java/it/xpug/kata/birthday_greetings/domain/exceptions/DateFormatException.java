package it.xpug.kata.birthday_greetings.domain.exceptions;

public class DateFormatException extends Exception{
    public DateFormatException(Throwable throwable){
        super(throwable);
    }
}
