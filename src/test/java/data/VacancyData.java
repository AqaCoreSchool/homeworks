package data;

import com.github.javafaker.Faker;

public class VacancyData {
    private static Faker faker = new Faker();
    private int jobTitleOption;
    private String vacanyName;
    private String hiringManager;
    private String positions;
    private String description;

    public VacancyData(String vacanyName, String hiringManager) {
        this.jobTitleOption = 1;
        this.vacanyName = vacanyName;
        this.hiringManager = hiringManager;
        this.positions = "1";
        this.description = faker.lorem().sentence(5);
    }

    public int getJobTitleOption() {
        return jobTitleOption;
    }

    public String getVacanyName() {
        return vacanyName;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public String getPositions() {
        return positions;
    }

    public String getDescription() {
        return description;
    }
}
