package rybka.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {
    private List<Employee> employeeList = new ArrayList<>();
    private Random random = new Random();

    public Company(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            if (isHired()) {
                this.employeeList.add(employee);
            }
        }
    }

    public boolean isHired() {
        return random.nextBoolean();
    }

    public void getEmployeesInSalaryMoreThan(int salary) {
        System.out.printf("|%-20s|\t|%-20s|\t|%-20s|%n", "Worker", "Salary", "Position");
        for (Employee employee : employeeList) {
            if (employee.getSalary() >= salary) {
                printEmployee(employee);
            }
        }
    }

    public void printEmployee() {
        System.out.printf("%n|%-20s|%n", "Workers");
        for (Employee employee : employeeList) {
            System.out.printf("|%20s|%n", employee.getName());
        }
    }

    public void printEmployee(Employee employee) {
        System.out.printf("|%20s|\t|%20s|\t|%20s|%n", employee.getName(), employee.getSalary(), employee.getClass().getSimpleName());
    }
}
