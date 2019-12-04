package testpackage.factory;

import com.github.javafaker.Faker;
import testpackage.entity.Vacancy;

public class VacancyFactory {

    private Faker faker;

    public Vacancy defaultVacancy(){
        return Vacancy.builder()
                .hiringManager("Danylo Alexandrovich Pazykov")
                .jobTitle("Junior")
                .vacancy("AQA")
                .status("Active")
                .build();
    }

    public Vacancy randomVacancy(){
        return Vacancy.builder()
                .hiringManager(faker.name().fullName())
                .jobTitle(faker.job().title())
                .vacancy(faker.job().position())
                .status("Active")
                .build();

    }
}
