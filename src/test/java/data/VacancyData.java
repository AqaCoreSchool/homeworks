package data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.javafaker.Faker;

@JsonDeserialize(as = VacancyData.class)
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

        if (jobTitleOption != that.jobTitleOption) return false;
        if (!vacancyName.equals(that.vacancyName)) return false;
        if (!hiringManager.equals(that.hiringManager)) return false;
        if (!positions.equals(that.positions)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = jobTitleOption;
        result = 31 * result + vacancyName.hashCode();
        result = 31 * result + hiringManager.hashCode();
        result = 31 * result + positions.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
