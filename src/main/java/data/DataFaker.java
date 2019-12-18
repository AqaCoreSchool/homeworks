package data;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataFaker {
    private Faker faker;
    private Candidate candidate;
    private Location location;
    private UserInformation userInformation;
    private Vacancy vacancy;

    private Random random;

    public DataFaker() {
        faker = new Faker();
        candidate = new Candidate();
        location = new Location();
        userInformation = new UserInformation();
        vacancy = new Vacancy();
        random = new Random();
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public DataFaker setVacancy() {
        vacancy.setPosition(faker.job().position());
        return this;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public DataFaker setCandidate() {
        candidate.setFirstName(faker.name().firstName());
        candidate.setLastName(faker.name().lastName());
        candidate.setEmail(faker.internet().emailAddress());

        return this;
    }

    public Location getLocation() {
        return location;
    }

    public DataFaker setLocation() {
        location.setLocationName(faker.company().name());
        location.setLocationState(faker.address().state());
        location.setLocationCity(faker.address().cityName());
        location.setLocationAddress(faker.address().streetAddress());
        location.setLocationPostalCode(faker.address().zipCode());

        return this;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public DataFaker setUserInformation() {
        userInformation.setFirstName(faker.name().firstName());
        userInformation.setLastName(faker.name().lastName());
        userInformation.setGenderValue(Integer.toString(random.nextInt(2)));
        userInformation.setMaritalStatus("Single");
        userInformation.setNationValue(Integer.toString(random.nextInt(194)));
        userInformation.setBirthdayValue(String.format("%d-%d-%d",
                faker.number().numberBetween(1970, 2010),
                faker.number().numberBetween(10, 12),
                faker.number().numberBetween(10, 27)));

        return this;
    }
}
