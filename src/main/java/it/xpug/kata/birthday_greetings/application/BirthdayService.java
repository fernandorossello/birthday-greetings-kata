package it.xpug.kata.birthday_greetings.application;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.Message;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.domain.exceptions.DataExtractionException;
import it.xpug.kata.birthday_greetings.domain.exceptions.DateFormatException;

import java.util.List;

public class BirthdayService {

	private final NotificationService mailService;
	private final EmployeeRepository employeeRepository;

	public BirthdayService(NotificationService mailService, EmployeeRepository employeeRepository)
	{
		this.mailService = mailService;
		this.employeeRepository = employeeRepository;
	}

	public void sendGreetings(XDate xDate) throws DataExtractionException, DateFormatException {
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
