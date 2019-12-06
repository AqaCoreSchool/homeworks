package com.company.vTests.data;

import com.github.javafaker.Faker;

import java.util.Objects;

public class Vacancy {
    private String jobTitle;
    private String vacancyName;
    private String hiringManagerName;
    private String numberOfPositions;
    private String description;


    public Vacancy() {
        this.jobTitle = "AQA";
        this.vacancyName = Faker.instance().job().seniority();
        this.hiringManagerName = "Olya Bilynska";
        this.numberOfPositions = Faker.instance().number().digits(1);
        this.description = "Some text";
    }

    public Vacancy(String jobTitle,
                    String vacancyName,
                    String hiringManagerName,
                    String numberOfPositions,
                    String description) {
        this.jobTitle = jobTitle;
        this.vacancyName = vacancyName;
        this.hiringManagerName = hiringManagerName;
        this.numberOfPositions = numberOfPositions;
        this.description = description;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public String getHiringManagerName() {
        return hiringManagerName;
    }

    public String getNumberOfPositions(){return numberOfPositions;}

    public String getDescription(){return description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;
        if (!jobTitle.equals(vacancy.jobTitle)) return false;
        if (!numberOfPositions.equals(vacancy.numberOfPositions)) return false;
        if (!hiringManagerName.equals(vacancy.hiringManagerName)) return false;
        if (!description.equals(vacancy.description)) return false;
        return vacancyName.equals(vacancy.vacancyName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(jobTitle, numberOfPositions, hiringManagerName, vacancyName,
                description);
    }
}
