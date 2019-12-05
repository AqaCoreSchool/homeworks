package selenium.model;

import com.github.javafaker.Faker;

import java.util.Objects;

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

    public Location(String name, String country, String city, String phone) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.phone = phone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) &&
                Objects.equals(country, location.country) &&
                Objects.equals(city, location.city) &&
                Objects.equals(phone, location.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, city, phone);
    }
}
