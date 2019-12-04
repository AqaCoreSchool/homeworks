package data;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CandidateData {
    private static Faker faker = new Faker();
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String vacancyName;
    private String hiringManager;
    private String comment;
    private String date;

    public CandidateData(String vacancyName, String hiringManager, String date) {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.contactNo = faker.idNumber().valid();
        this.vacancyName = vacancyName;
        this.hiringManager = hiringManager;
        this.comment = faker.lorem().sentence(3);
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

}
