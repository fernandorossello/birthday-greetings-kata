package it.xpug.kata.birthday_greetings.application;

import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.exceptions.DataExtractionException;

import java.text.ParseException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> getEmployees() throws ParseException, DataExtractionException;
}
