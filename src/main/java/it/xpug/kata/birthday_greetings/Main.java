package it.xpug.kata.birthday_greetings;

import it.xpug.kata.birthday_greetings.application.BirthdayService;
import it.xpug.kata.birthday_greetings.application.EmployeeRepository;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.domain.exceptions.DataExtractionException;
import it.xpug.kata.birthday_greetings.domain.exceptions.DateFormatException;
import it.xpug.kata.birthday_greetings.infrastructure.MailService;
import it.xpug.kata.birthday_greetings.infrastructure.repositories.EmployeeFileRepository;

public class Main {

	public static void main(String[] args) throws DateFormatException, DataExtractionException {
		MailService mailService = new MailService("localhost", 25);
		EmployeeRepository employeeRepository = new EmployeeFileRepository("employee_data.txt");
		BirthdayService birthdayservice = new BirthdayService(mailService, employeeRepository);
		birthdayservice.sendGreetings(new XDate());
	}

}
