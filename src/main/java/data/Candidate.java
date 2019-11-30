package data;

import com.github.javafaker.Faker;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;

    public void setCandidateInfo() {
        Faker faker = new Faker();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
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
}
