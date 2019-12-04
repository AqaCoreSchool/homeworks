package testpackage.factory;

import com.github.javafaker.Faker;
import testpackage.entity.User;

public class UserFactory {

    private Faker faker;

    public User defaultUser(){
        return User.builder()
                .firstName("Danylo")
                .middleName("Alexandrovich")
                .lastName("Pazykov")
                .id("646558")
                .dateOfBirth("2001-05-04")
                .build();
    }

    public User randomUser(){
        return User.builder()
                .firstName(faker.name().firstName())
                .middleName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .id(faker.idNumber().invalid())
                .dateOfBirth(faker.date().birthday().toString())
                .build();
    }
}
