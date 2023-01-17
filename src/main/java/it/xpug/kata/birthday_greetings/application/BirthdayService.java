package it.xpug.kata.birthday_greetings.application;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.Message;
import it.xpug.kata.birthday_greetings.domain.XDate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class BirthdayService {

	private final NotificationService mailService;
	private final EmployeeRepository employeeRepository;

	public BirthdayService(NotificationService mailService, EmployeeRepository employeeRepository)
	{
		this.mailService = mailService;
		this.employeeRepository = employeeRepository;
	}

	public void sendGreetings(XDate xDate) throws IOException, ParseException {
		List<Employee> employees = employeeRepository.getEmployees();
		for (Employee employee: employees) {
			if (employee.isBirthday(xDate)) {
				String recipient = employee.getEmail();
				String body = "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstName());
				String subject = "Happy Birthday!";
				Message message = new Message("sender@here.com", subject, body, recipient);
				mailService.sendMessage(message);
			}
		}
	}


}
