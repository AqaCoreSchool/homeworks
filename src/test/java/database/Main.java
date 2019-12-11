package database;

import database.dataprovider.EmployeeSQLDataProvider;
import database.dataprovider.VacancySQLDataProvider;
import selenium.model.Candidate;
import selenium.model.Vacancy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeSQLDataProvider employeeSQLDataProvider = new EmployeeSQLDataProvider();
        System.out.println("Enter vacancy name to get employee: ");
        String vacancyName = scanner.nextLine();
        List<Candidate> candidates = employeeSQLDataProvider.getEmployeesByJobVacancyName(vacancyName);
        System.out.println(String.format("Employee by vacancy name: %s", vacancyName));
        for (Candidate candidate : candidates) {
            System.out.println(String.format("%s %s", candidate.getCandidateFirstName(),
                    candidate.getCandidateLastName()));
        }


        System.out.println("Enter Employee firstname and lastname to get vacancy:");
        String name = scanner.next();
        String lastName = scanner.next();
        VacancySQLDataProvider vacancySQLDataProvider = new VacancySQLDataProvider();
        List<Vacancy> vacancies = vacancySQLDataProvider.getVacanciesByEmployeeName(name, lastName);
        System.out.println(String.format("Vacancies by employee name: %s %s", name, lastName));
        for (Vacancy vacancy : vacancies) {
            System.out.println(vacancy.getVacancyName()); // Quality Assurance
        }
    }
}
