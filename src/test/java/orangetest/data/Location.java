package orangetest.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import java.util.Objects;

public class Location {
    private String name;
    private String country;
    private String state;
    private String city;
    private String address;
    private String zipPostalCode;

    @JsonIgnore
    private Faker faker = new Faker();

    public Location() {
        this.name = faker.name();
        this.country = faker.country();
        this.state = faker.stateAbbr();
        this.city = faker.cityPrefix();
        this.address = faker.secondaryAddress();
        this.zipPostalCode = faker.zipCode();
    }

    public Location(String name, String country, String state, String city, String address, String zipPostalCode, Faker faker) {
        this.name = name;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.zipPostalCode = zipPostalCode;
        this.faker = faker;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return this.getName().equals(location.getName()) &&
                this.getCountry().equals(location.country) &&
                this.getState().equals(location.state) &&
                this.getCity().equals(location.city) &&
                this.getAddress().equals(location.address) &&
                this.getZipPostalCode().equals(location.zipPostalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, state, city, address, zipPostalCode);
    }

}
