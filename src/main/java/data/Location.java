package data;

import com.github.javafaker.Faker;

public class Location {
    private String locationName;
    private int locationCountryIndex;
    private String locationState;
    private String locationCity;
    private String locationAddress;
    private String locationPostalCode;

    public void setLocation(){
        Faker faker = new Faker();

        locationName = faker.company().name();
        locationState = faker.address().state();
        locationCity = faker.address().cityName();
        locationAddress = faker.address().streetAddress();
        locationPostalCode = faker.address().zipCode();
    }

    public String getLocationName() {
        return locationName;
    }

    public int getLocationCountryIndex() {
        return locationCountryIndex;
    }

    public void setLocationCountryIndex(int locationCountryIndex) {
        this.locationCountryIndex = locationCountryIndex;
    }

    public String getLocationState() {
        return locationState;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getLocationPostalCode() {
        return locationPostalCode;
    }
}
