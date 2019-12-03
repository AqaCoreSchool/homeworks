package data;

import com.github.javafaker.Faker;

public class LocationData {
    private static Faker faker = new Faker();
    private String name;
    private String countryCode;
    private String state;
    private String city;
    private String address;
    private String zip;
    private String phone;
    private String fax;
    private String notes;

    public LocationData() {
        this.name = faker.country().capital();
        this.countryCode = faker.address().countryCode();
        this.state = faker.address().state();
        this.city = faker.address().cityName();
        this.address = faker.address().fullAddress();
        this.zip = faker.address().zipCode();
        this.phone = faker.phoneNumber().cellPhone();
        this.fax = faker.phoneNumber().subscriberNumber(6);
        this.notes = faker.company().catchPhrase();
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
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

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getNotes() {
        return notes;
    }
}
