package it.xpug.kata.birthday_greetings.domain.exceptions;

public class DataExtractionException extends Exception{
    public DataExtractionException(Throwable throwable){
        super(throwable);
    }
}
