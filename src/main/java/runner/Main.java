package runner;

import pojo.Employee;
import pojo.JobVacancy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        application.getEmployee();
        application.getVacancy();
        //application.getEmployees().forEach(System.out::println);
        
        List<Employee> employees = application.getEmployeesByJobVacancyName("Test");
        System.out.println(employees);
        List<JobVacancy> vacancies = application.getVacanciesByEmployeeName("Abernathy", "Bobbie");
        System.out.println(vacancies);
    }
}
