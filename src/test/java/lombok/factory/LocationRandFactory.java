package lombok.factory;

import com.github.javafaker.Faker;
import lombok.random.LocationRand;

public class LocationRandFactory {

    private Faker faker = new Faker();

    public LocationRand randomLocation(){
        return LocationRand.builder()
                .locationName(faker.company().name())
                .country(faker.country().name())
                .province(String.format("%s region", faker.address().city()))
                .city(faker.country().capital())
                .address(faker.address().streetAddress())
                .postalCode(faker.address().countryCode())
                .phone(faker.phoneNumber().cellPhone())
                .build();
    }
}
