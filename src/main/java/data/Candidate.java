package data;

import com.github.javafaker.Faker;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String jobVacancyValue;

    public void setCandidateInfo() {
        Faker faker = new Faker();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        contactNo = faker.phoneNumber().cellPhone();
        jobVacancyValue = "270";
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

    public String getJobVacancyValue() {
        return jobVacancyValue;
    }
}
