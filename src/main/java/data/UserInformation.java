package data;

import com.github.javafaker.Faker;

import java.util.Random;

public final class UserInformation {
    private String firstName;
    private String lastName;
    private String genderValue;
    private String maritalStatus;
    private String nationValue;
    private String birthdayValue;

    public void setUserInformation() {
        Faker faker = new Faker();
        Random random = new Random();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        genderValue = Integer.toString(random.nextInt(2));
        maritalStatus = "Single";
        nationValue = Integer.toString(random.nextInt(194));
        birthdayValue = String.format("%d-%d-%d",
                faker.number().numberBetween(1970, 2010),
                faker.number().numberBetween(10, 12),
                faker.number().numberBetween(10, 27));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGenderValue() {
        return genderValue;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getNationValue() {
        return nationValue;
    }

    public String getBirthdayValue() {
        return birthdayValue;
    }
}
