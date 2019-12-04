package orangetest.data;

import com.github.javafaker.Faker;

public class Location {
    private String name;
    private String country;
    private String state;
    private String city;
    private String address;
    private String zipPostalCode;
    private Faker faker = new Faker();

    public Location() {
        this.name = faker.name();
        this.country = faker.country();
        this.state = faker.stateAbbr();
        this.city = faker.cityPrefix();
        this.address = faker.secondaryAddress();
        this.zipPostalCode = faker.zipCode();
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

}
