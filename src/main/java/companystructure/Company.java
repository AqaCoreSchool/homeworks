package companystructure;

import java.util.ArrayList;
import java.util.List;

public class Company {
    static List<Employee> hiredEmployeeList = new ArrayList();
    static List<Employee> employeeList = new ArrayList();
    private static Company singleInstance;
    final String TABLE_BORDER = String.format("+-------------------------+---------------+-------------------------+-------------------------+");
    List<String> namesEmployeeList = new ArrayList();
    List<Employee> salaryEmployeeList = new ArrayList();

    public static Company getInstance() {
        if (singleInstance == null) {
            singleInstance = new Company();
        }
        return singleInstance;
    }

    List<Employee> getEmployeesWithSalaryMoreThan(int salary, List<Employee> hiredEmployeeList) {
        for (Employee e : hiredEmployeeList) {
            if (e.salary >= salary) {
                salaryEmployeeList.add(e);
                namesEmployeeList.add(e.name);
            }
        }
        return salaryEmployeeList;
    }

    void getHiredEmployees(List<Employee> employees) {
        for (Employee e : employees) {
            if (e.hired) {
                hiredEmployeeList.add(e);
            }
        }
    }

    void addEmployeeToList(Employee employee) {
        employeeList.add(employee);
    }

    void printEmployeesNames(List<Employee> employees) {
        if (!employees.isEmpty()) {
            System.out.println("+-------------------------+");
            System.out.println(String.format("|%-25s|", "Name"));
            for (Employee p : employees) {
                System.out.println(String.format("|%-25s|", p.name));
            }
        } else
            System.out.println("Opps, where are our employees? We need a people!");

    }

    void printEmployeesList(List<Employee> employees) {
        if (!employees.isEmpty()) {
            System.out.println(TABLE_BORDER);
            System.out.println(String.format("|%-25s|%-15s|%-25s|%-25s|", "Name", "Salary", "Is hired", "Position"));
            System.out.println(TABLE_BORDER);
            for (Employee p : employees) {
                System.out.println(String.format("|%-25s|%-15s|%-25s|%-25s|", p.name, p.salary, p.hired, p.position));
            }
            System.out.println(TABLE_BORDER);
        } else {
            System.out.println("Opps, where are our employees? We need a people!");
        }
    }
}

