package com.example.Collections.VarOfImpl.Collections.VarOfImpl.model;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String toString() {
        return "firstName: " + getFirstName() + ", lastName: " + getLastName() + ".";
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return Objects.equals(getFirstName(), employee.firstName) && Objects.equals(getLastName(), employee.lastName);
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
