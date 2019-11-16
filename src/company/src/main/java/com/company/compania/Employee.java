package com.company.compania;

import com.github.javafaker.Faker;

public class Employee {
    private String employeeName;
    private int employeeSalary;

    Faker faker = new Faker();
    private boolean employeeIsHired = faker.random().nextBoolean();

    public Employee(String name, int salary, boolean isHired) {
        employeeName = name;
        employeeSalary = salary;
        employeeIsHired = isHired;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public double getEmployeeSalary() {
        return employeeSalary;
    }
    public boolean isEmployeeHired() {
        return employeeIsHired;
    }

    public String toString() {
        return String.format("<%s> |%d| (%b)", employeeName, employeeSalary, employeeIsHired);

    }
}