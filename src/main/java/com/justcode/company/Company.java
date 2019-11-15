package com.justcode.company;

import com.justcode.company.employee.Employee;
import com.justcode.company.exceptions.NotFoundAnyEmployeeException;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private List<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() throws NotFoundAnyEmployeeException {
        if (employees.isEmpty()) {
            throw new NotFoundAnyEmployeeException("Список працівників компанії порожній");
        }
        return employees;
    }

    public int getNumberOfEmployee() {
        return employees.size();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
