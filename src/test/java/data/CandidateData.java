package data;

import com.github.javafaker.Faker;

import java.util.Objects;

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

    private CandidateData(){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateData that = (CandidateData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(contactNo, that.contactNo) &&
                Objects.equals(vacancyName, that.vacancyName) &&
                Objects.equals(hiringManager, that.hiringManager) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, contactNo, vacancyName, hiringManager, comment, date);
    }
}
