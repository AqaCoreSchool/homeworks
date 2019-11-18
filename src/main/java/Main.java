import company.Company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args){
        Company company = new Company();
        System.out.println("------------------------------");
        company.printEmployees(company.getEmployeesList());
        System.out.println("------------------------------");
        company.printEmployees(company.isRealWorker(company.getEmployeesList()));
        System.out.println("------------------------------");
        company.printEmployees(company.getEmployeesWithSalaryMoreThan(2000));
    }
}
