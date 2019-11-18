package company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Employee> employeesFilteredBySalary = new ArrayList<>();
        int salaryFilter = 1500;
        Company company = new Company("NKsoft");
        company.hireEmployee(new Director("Tom the CEO", 5000, true));
        company.hireEmployee(new Manager("Daniel", setManagerSalary(), setHireStatus()));
        company.hireEmployee(new Manager("Anna", setManagerSalary(), setHireStatus()));
        company.hireEmployee(new Manager("John", setManagerSalary(), setHireStatus()));
        company.hireEmployee(new Manager("Ivan", setManagerSalary(), setHireStatus()));
        company.hireEmployee(new Developer("Jacob", setDeveloperSalary(), setHireStatus()));
        company.hireEmployee(new Developer("Terry", setDeveloperSalary(), setHireStatus()));
        company.hireEmployee(new Developer("Jasmina", setDeveloperSalary(), setHireStatus()));
        company.hireEmployee(new Developer("Peter", setDeveloperSalary(), setHireStatus()));
        company.hireEmployee(new Developer("Carl", setDeveloperSalary(), setHireStatus()));
        company.hireEmployee(new Developer("Brett", setDeveloperSalary(), setHireStatus()));
        company.hireEmployee(new QA("Mary", setQASalary(), setHireStatus()));
        company.hireEmployee(new QA("Lilia", setQASalary(), setHireStatus()));
        company.hireEmployee(new QA("Sam", setQASalary(), setHireStatus()));
        company.hireEmployee(new QA("Alex", setQASalary(), setHireStatus()));
        company.hireEmployee(new QA("Neil", setQASalary(), setHireStatus()));
        company.hireEmployee(new Accountant("Sara", setAccountantSalary(), setHireStatus()));
        company.hireEmployee(new Accountant("Samantha", setAccountantSalary(), setHireStatus()));

        System.out.println("All hired employees:");
        company.printEmployees(company.getEmployeeList());

        System.out.printf("\nSalary more then %d $\n", salaryFilter);
        employeesFilteredBySalary = company.getEmployeesWithSalaryMoreThen(salaryFilter);
        company.printEmployees(employeesFilteredBySalary);


    }

    public static boolean setHireStatus() {
        return (int) (Math.random() * 100) >= 50;
    }

    public static int setManagerSalary() {
        return (int) (800 + Math.random() * 2200);
    }

    public static int setDeveloperSalary() {
        return (int) (500 + Math.random() * 2500);
    }

    public static int setQASalary() {
        return (int) (400 + Math.random() * 1800);
    }

    public static int setAccountantSalary() {
        return (int) (400 + Math.random() * 1500);
    }

}
