package it.xpug.kata.birthday_greetings.infrastructure.repositories;

import it.xpug.kata.birthday_greetings.application.EmployeeRepository;
import it.xpug.kata.birthday_greetings.domain.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFileRepository implements EmployeeRepository {
    private static final int FIRST_NAME = 1;
    private static final int LAST_NAME = 0;
    private static final int BIRTHDATE = 2;
    private static final int EMAIL = 3;
    private static final String SEPARATION_TOKEN = ", ";
    private final String fileName;

    public EmployeeFileRepository(String filename){

        this.fileName = filename;
    }

    public List<Employee> getEmployees() throws IOException, ParseException {
        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
        LinkedList<Employee> employees = new LinkedList<>();
        String str;
        in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(SEPARATION_TOKEN);
            employees.add(new Employee(employeeData[FIRST_NAME], employeeData[LAST_NAME], employeeData[BIRTHDATE], employeeData[EMAIL]));
        }
        return employees;
    }
}
