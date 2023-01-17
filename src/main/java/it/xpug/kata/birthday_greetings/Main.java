package it.xpug.kata.birthday_greetings;

import it.xpug.kata.birthday_greetings.application.BirthdayService;
import it.xpug.kata.birthday_greetings.application.EmployeeRepository;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.infrastructure.MailService;
import it.xpug.kata.birthday_greetings.infrastructure.repositories.EmployeeFileRepository;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		MailService mailService = new MailService("localhost", 25);
		EmployeeRepository employeeRepository = new EmployeeFileRepository("employee_data.txt");
		BirthdayService birthdayservice = new BirthdayService(mailService, employeeRepository);
		birthdayservice.sendGreetings(new XDate());
	}

}
