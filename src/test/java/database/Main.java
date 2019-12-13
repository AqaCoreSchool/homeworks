package database;

import database.dataprovider.EmployeeSQLDataProvider;
import database.dataprovider.VacancySQLDataProvider;
import selenium.model.Candidate;
import selenium.model.Vacancy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VacancySQLDataProvider vacancyProvider = new VacancySQLDataProvider();
        System.out.println("Getting employee name by vacancy name 'Quality Assurance'");
        vacancyProvider.getData();
        List<Candidate> resultList = vacancyProvider.getEmployeesByJobVacancyName("Quality Assurance");
        for (Candidate candidate : resultList) {
            System.out.println(String.format("%s %s",
                    candidate.getCandidateFirstName(),
                    candidate.getCandidateLastName()));
        }

        System.out.println("Getting vacancy name by employee name 'Pavlo Hrytsyshyn'");
        EmployeeSQLDataProvider employeeProvider = new EmployeeSQLDataProvider();
        List<Vacancy> result = employeeProvider.getVacanciesByEmployeeName("Pavlo", "Hrytsyshyn");
        for (Vacancy candidate : result) {
            System.out.println(candidate.getVacancyName());
        }
    }
}
