package companystructure;

import java.util.InputMismatchException;
import java.util.Scanner;

import static companystructure.Company.*;


public class Main {

    public static void main(String[] args) {
        Company myCompany = getInstance();
     /*   Employee e1 = new Director("Iron Man", 5000);
        Employee e2 = new Director("Captain America", 4000);
        Employee q1 = new QA("Impossible Man", 1200);
        Employee q2 = new QA("Dragon Man", 1200);
        Employee q3 = new QA("Dracula ", 1300);
        Employee d1 = new Developer("Black Panther", 3000);
        Employee d2 = new Developer("Deadpool", 3000);
        Employee d4 = new Developer("Ant Man", 3300);
        Employee d5 = new Developer("Captain Marvel", 2900);
        Employee m1 = new Manager("Ben Parker", 2500);
        Employee m2 = new Manager("Black Bird", 2600);
        Employee m3 = new Manager("Black Queen", 2400);
        Employee a1 = new Accountant("Dark Phoenix", 2400);
        Employee a2 = new Accountant("Doctor Strange", 2600); */
        System.out.println("List of all Employees");
        myCompany.printEmployeesList(employeeList);
        myCompany.getHiredEmployees(employeeList);
        System.out.println("\nList of hired Employees ");
        myCompany.printEmployeesList(Company.hiredEmployeeList);
        System.out.println("\nList of hired Employees names");          // №2
        myCompany.printEmployeesNames(hiredEmployeeList);
        System.out.println("\nPlease, enter minimal salary for search"); // №1
        Scanner scanner = new Scanner(System.in);
        try {
            int minSalary = scanner.nextInt();
            System.out.println(String.format("%-25s%,d%-1s", "\nList of hired Employees with salary more than ", minSalary, "$"));
            myCompany.printEmployeesList(myCompany.getEmployeesWithSalaryMoreThan(minSalary, hiredEmployeeList)); // hired or all employees
        } catch (InputMismatchException e) {
            System.out.println("Wrong data format, it should be integer number");
        }
    }
}
