package data;

import com.github.javafaker.Faker;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;

    public Candidate() {
        Faker faker = new Faker();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        contactNo = faker.phoneNumber().cellPhone();
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
}
