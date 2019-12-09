package selenium.model;

import com.github.javafaker.Faker;

public class Location {
    private String name;
    private String country;
    private String city;
    private String phone;

    public Location() {
        this.name = Faker.instance().name().fullName();
        this.country = Faker.instance().country().name();
        this.city = Faker.instance().country().capital();
        this.phone = Faker.instance().phoneNumber().subscriberNumber(11);
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }
}
