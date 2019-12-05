package data;

import com.github.javafaker.Faker;

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

        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!email.equals(that.email)) return false;
        if (!contactNo.equals(that.contactNo)) return false;
        if (!vacancyName.equals(that.vacancyName)) return false;
        if (!hiringManager.equals(that.hiringManager)) return false;
        if (!comment.equals(that.comment)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + contactNo.hashCode();
        result = 31 * result + vacancyName.hashCode();
        result = 31 * result + hiringManager.hashCode();
        result = 31 * result + comment.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
