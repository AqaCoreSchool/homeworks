package testpackage.factory;

import com.github.javafaker.Faker;
import testpackage.entity.Location;

public class LocationFactory {

    private Faker faker;

    public Location defaultLocation(){
        return Location.builder()
                .name("Danylo Alexandrovich Pazykov")
                .country("Ukraine")
                .city("Lviv")
                .address("Prospect Red Kalina 7a")
                .postalCode("79000")
                .phoneNumber("+380506442833")
                .build();
    }

    public Location randomLocation(){
        return Location.builder()
                .name(faker.name().fullName())
                .country(faker.country().name())
                .city(faker.address().city())
                .address(faker.address().streetAddress())
                .postalCode(faker.address().countryCode())
                .phoneNumber(faker.phoneNumber().phoneNumber())
                .build();
    }
}
