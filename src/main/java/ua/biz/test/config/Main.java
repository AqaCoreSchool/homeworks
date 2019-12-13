package ua.biz.test.config;

import ua.biz.test.pojo.Employee;
import ua.biz.test.pojo.JobVacancy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private Application application;
    private List<Employee> employees;
    private List<JobVacancy> vacancies;

    public Main() {
        employees = new ArrayList<>();
        vacancies = new ArrayList<>();

        application = new Application();
        application.getEmployee();
        application.getVacancy();
    }

    public Main setEmployeeList(String jobVacancyName) {
        employees = application.getEmployeesByJobVacancyName(jobVacancyName);
        System.out.println(employees);

        return this;
    }

    public Main setVacancyList(String name, String lastName) {
        vacancies = application.getVacanciesByEmployeeName(name, lastName);
        System.out.println(vacancies);

        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<JobVacancy> getVacancies() {
        return vacancies;
    }
}
