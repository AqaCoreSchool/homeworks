package com.justcode;

import com.justcode.company.Company;
import com.justcode.company.CompanyAccount;
import com.justcode.company.employee.*;
import com.justcode.company.exceptions.NotFoundAnyEmployeeException;

public class Main {
    static private CompanyAccount account = new CompanyAccount(new Company("JustCode"));

    public static void main(String[] args) {
        addTestEmployees();
        account.printEmployeesName();
        account.printEmployeesData(account.getSortedEmployeesBySalary(1500, 3500));
        try {
            account.printEmployeesData(account.getAllPermanentEmployee());
        } catch (NotFoundAnyEmployeeException e) {
            e.printStackTrace();
        }
    }

    private static void addTestEmployees() {
        account.addNewEmployee(new Director("John Jonson", 5700, false));
        account.addNewEmployee(new Accountant("Maria Ivankiv", 1500, false));
        account.addNewEmployee(new Manager("Igor Rostovich", 2300, false));
        account.addNewEmployee(new Manager("Ann Lesiv", 2100, false));
        account.addNewEmployee(new Developer("Taras Rug", 2500, false));
        account.addNewEmployee(new Developer("Andriy Tkach", 2300, false));
        account.addNewEmployee(new Developer("Roman Kravchuk", 3500, true));
        account.addNewEmployee(new QualityAssuranceEngineer("Roman Kravchuk", 2500, false));
        account.addNewEmployee(new QualityAssuranceEngineer("Ira Matisova", 3100, true));
        account.addNewEmployee(new QualityAssuranceEngineer("Roman Androp", 3200, true));
    }
}
