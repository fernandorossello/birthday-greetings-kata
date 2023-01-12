package it.xpug.kata.birthday_greetings;

import java.text.ParseException;

public class Employee {

    private final XDate birthDate;
    private final String lastName;
    private final String firstName;
    private final String email;

    public Employee(String firstName, String lastName, String birthDate, String email)
        throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = new XDate(birthDate);
        this.email = email;
    }

    public boolean isBirthday(XDate today) {
        return today.isSameDay(birthDate);
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Employee " + firstName + " " + lastName + " <" + email + "> born " + birthDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + birthDate.hashCode();
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result
            + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result
            + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;
        if (!birthDate.equals(other.birthDate)) {
            return false;
        }

        if (!areEqual(email, other.email)) {
            return false;
        }

        if (!areEqual(firstName, other.firstName)) {
            return false;
        }

        return areEqual(lastName, other.lastName);
    }

    private boolean areEqual(String s1, String s2) {
        if (s1 == null) {
            return s2 == null;
        } else {
            return s1.equals(s2);
        }
    }
}
