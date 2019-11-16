package company;

import company.employees.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company myCompany = new Company();
        List<Employee> allEmployees = myCompany.getAllEmployees();

        System.out.println(allEmployees);
        myCompany.printEmployeeNames(allEmployees);
        System.out.println(myCompany.getEmployeesWithSalaryMoreThan(allEmployees, 2000));
        System.out.println(myCompany.getHiredEmployees(allEmployees));





    }
}
