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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationData that = (LocationData) o;

        if (!name.equals(that.name)) return false;
        if (!countryCode.equals(that.countryCode)) return false;
        if (!state.equals(that.state)) return false;
        if (!city.equals(that.city)) return false;
        if (!address.equals(that.address)) return false;
        if (!zip.equals(that.zip)) return false;
        if (!phone.equals(that.phone)) return false;
        if (!fax.equals(that.fax)) return false;
        return notes.equals(that.notes);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + countryCode.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + zip.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + fax.hashCode();
        result = 31 * result + notes.hashCode();
        return result;
    }

}
