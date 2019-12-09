package data;

import com.github.javafaker.Faker;

import java.util.Objects;

public class VacancyData {
    private static Faker faker = new Faker();
    private int jobTitleOption;
    private String vacancyName;
    private String hiringManager;
    private String positions;
    private String description;

    public VacancyData(String vacancyName, String hiringManager) {
        this.jobTitleOption = 1;
        this.vacancyName = vacancyName;
        this.hiringManager = hiringManager;
        this.positions = "1";
        this.description = faker.lorem().sentence(5);
    }

    private VacancyData(){
    }

    public int getJobTitleOption() {
        return jobTitleOption;
    }

    public String getVacancyName() {
        return vacancyName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacancyData that = (VacancyData) o;
        return jobTitleOption == that.jobTitleOption &&
                Objects.equals(vacancyName, that.vacancyName) &&
                Objects.equals(hiringManager, that.hiringManager) &&
                Objects.equals(positions, that.positions) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobTitleOption, vacancyName, hiringManager, positions, description);
    }
}
