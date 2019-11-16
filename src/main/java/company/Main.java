package company;

import company.employees.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee();
        List<Employee> allEmployees = employee.getAllEmployees();

        System.out.println(allEmployees);
        employee.printEmployeeNames(allEmployees);
        System.out.println(employee.getEmployeesWithSalaryMoreThan(allEmployees, 2000));
        System.out.println(employee.getHiredEmployees(allEmployees, true));





    }
}
