package it.xpug.kata.birthday_greetings.domain;

public class Message {
    private final String sender;
    private final String subject;
    private final String body;
    private final String recipient;

    public Message(String sender, String subject, String body, String recipient){
        this.body = body;
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getRecipient() {
        return recipient;
    }
}
