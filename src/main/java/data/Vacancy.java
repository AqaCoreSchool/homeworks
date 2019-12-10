package data;

import com.github.javafaker.Faker;

public class Vacancy {
    private String jobTitleValue;
    private String position;
    private int managerValue;

    public Vacancy() {
        Faker faker = new Faker();

        jobTitleValue = "1";
        position = faker.job().position();
        managerValue = faker.random().nextInt(1, 9);
    }

    public String getJobTitleValue() {
        return jobTitleValue;
    }

    public String getPosition() {
        return position;
    }

    public int getManagerValue() {
        return managerValue;
    }
}
