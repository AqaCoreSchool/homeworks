package com.justcode.company;

import com.justcode.company.employee.Employee;
import com.justcode.company.exceptions.NotFoundAnyEmployeeException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompanyAccount {
    private Company company;
    private List<Employee> sortedEmployees = new ArrayList<>(); //Перейменувати

    public CompanyAccount(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    //Додає нового працівника
    public void addNewEmployee(Employee employee) {
        company.addEmployee(employee);
    }

    //Повертає список співробітників з зарплатою в діапазоні
    public List<Employee> getSortedEmployeesBySalary(double from, double to) {
        sortedEmployees.clear();
        try {
            sortedEmployees.addAll(company.getEmployees());
        } catch (NotFoundAnyEmployeeException e) {
            e.printStackTrace();
        }
        sortedEmployees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        });
        return sortedEmployees;
    }

    //Повертаж список всіх постійних працівників
    public List<Employee> getAllPermanentEmployee() throws NotFoundAnyEmployeeException {
        sortedEmployees.clear();
        try {
            for (Employee employee : company.getEmployees()) {
                if (!employee.isHired()) {
                    sortedEmployees.add(employee);
                }
            }
        } catch (NotFoundAnyEmployeeException e) {
            e.printStackTrace();
        }

        if (sortedEmployees.isEmpty()) {
            throw new NotFoundAnyEmployeeException("За вашим пошуком працівників не знайдено");
        }
        return sortedEmployees;
    }

    //Показує вибраний список працівників
    public void printEmployeesData(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    //Показує список всіх працівників (ім'я посада статус)
    public void printEmployeesName() {
        String s = "";
        System.out.printf("%-30s %-30s %-20s%n", "Name", "Position", "Is Hired");
        System.out.println("-----------------------------------------------------------------------");
        try {
            for (Employee employee : company.getEmployees()) {
                System.out.printf("%-30s %-30s %-20s%n", employee.getName(),
                        employee.getClass().getSimpleName(), employee.getEmployeeStatus());
            }
        } catch (NotFoundAnyEmployeeException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}
