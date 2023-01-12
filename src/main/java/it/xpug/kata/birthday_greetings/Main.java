package it.xpug.kata.birthday_greetings;

import it.xpug.kata.birthday_greetings.application.BirthdayService;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.infrastructure.MailService;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		MailService mailService = new MailService("localhost", 25);
		BirthdayService birthdayservice = new BirthdayService(mailService);
		birthdayservice.sendGreetings("employee_data.txt", new XDate());
	}

}
