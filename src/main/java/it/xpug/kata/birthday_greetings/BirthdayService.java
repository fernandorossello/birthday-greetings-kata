package it.xpug.kata.birthday_greetings;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.infrastructure.MailService;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class BirthdayService {

	public void sendGreetings(String fileName, XDate xDate, String smtpHost, int smtpPort) throws IOException, ParseException, MessagingException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str = "";
		str = in.readLine(); // skip header
		while ((str = in.readLine()) != null) {
			String[] employeeData = str.split(", ");
			Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
			if (employee.isBirthday(xDate)) {
				String recipient = employee.getEmail();
				String body = "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstName());
				String subject = "Happy Birthday!";
				MailService mailService = new MailService(smtpHost, smtpPort);
				mailService.sendMessage("sender@here.com", subject, body, recipient);
			}
		}
	}


}
