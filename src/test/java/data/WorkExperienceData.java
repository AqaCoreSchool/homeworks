package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class WorkExperienceData {
    private static Faker faker = new Faker();
    private String company;
    private String jobTitle;
    private String fromDate;
    private String toDate;
    private String comment;

    public WorkExperienceData() {
        this.company = faker.company().name();
        this.jobTitle = faker.job().title();
        this.fromDate = LocalDate.now().minusDays(faker.number().numberBetween(100,356))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.toDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.comment = faker.job().seniority();
    }

    public String getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkExperienceData that = (WorkExperienceData) o;
        return Objects.equals(company, that.company) &&
                Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(fromDate, that.fromDate) &&
                Objects.equals(toDate, that.toDate) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, jobTitle, fromDate, toDate, comment);
    }
}
