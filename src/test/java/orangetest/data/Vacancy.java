package orangetest.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import java.util.Objects;

public class Vacancy {
    @JsonIgnore
    private Faker faker = new Faker();
    private String vacancyName = "AQA Junior" + faker.zipCode();
    private String hiringManager = "Mariana Romanivna Mykytovych";
    private String numberOfPositions = "2";

    public Vacancy() {
    }

    public Vacancy(Faker faker, String vacancyName, String hiringManager, String numberOfPositions) {
        this.faker = faker;
        this.vacancyName = vacancyName;
        this.hiringManager = hiringManager;
        this.numberOfPositions = numberOfPositions;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public String getNumberOfPositions() {
        return numberOfPositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return this.vacancyName.equals(vacancy.vacancyName) &&
                this.hiringManager.equals(vacancy.hiringManager) &&
                this.numberOfPositions.equals(vacancy.numberOfPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacancyName, hiringManager, numberOfPositions);
    }
}
