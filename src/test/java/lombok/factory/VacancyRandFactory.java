package lombok.factory;

import com.github.javafaker.Faker;
import lombok.random.VacancyRand;

public class VacancyRandFactory {
    private Faker faker =new Faker();

    public VacancyRand randomVacancy(){
        return VacancyRand.builder()
                .vacancy(faker.job().position())
                .jobTitle(faker.job().title())
                .hiringManager(faker.name().fullName())
                .status("Active")
                .build();
    }
}
