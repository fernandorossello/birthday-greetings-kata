package it.xpug.kata.birthday_greetings.application;

import it.xpug.kata.birthday_greetings.domain.Employee;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> getEmployees() throws IOException, ParseException;
}
