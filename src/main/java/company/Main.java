package rybka.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Director("Dora C. Hawkins", 10000));
        employees.add(new Director("Sarah L. Edwards", 18000));
        employees.add(new Director("Leslie R. Smith", 15000));
        employees.add(new Manager("Karen A. Dunn", 1000));
        employees.add(new Manager("Karen T. Robert", 3000));
        employees.add(new Manager("Paul J. Taylor", 3500));
        employees.add(new Developer("Ivan L. Maglione", 6300));
        employees.add(new Developer("Jack P. Hoffman", 7100));
        employees.add(new Developer("Tanesha J. Clower", 7700));
        employees.add(new QualityAssurance("Crystal J. Rivera", 3400));
        employees.add(new QualityAssurance("Timothy L. Alexander", 2800));
        employees.add(new QualityAssurance("Hattie S. Lorentzen", 2500));
        employees.add(new Accountant("Steven D. Fong", 2000));
        employees.add(new Accountant("Karen E. Davis", 2300));
        employees.add(new Accountant("Brian A. Padgett", 3000));

        Company company = new Company(employees);
        company.getEmployeesInSalaryMoreThan(2500);
        company.printEmployee();
    }
}
