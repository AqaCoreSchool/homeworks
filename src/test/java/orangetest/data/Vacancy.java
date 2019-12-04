package orangetest.data;

import com.github.javafaker.Faker;

public class Vacancy {
    private Faker faker = new Faker();
    private String vacancyName = "AQA Junior" + faker.zipCode();
    private String hiringManager = "Mariana Romanivna Mykytovych";
    private String  numberOfPositions = "2";

    public Vacancy() {
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
}
