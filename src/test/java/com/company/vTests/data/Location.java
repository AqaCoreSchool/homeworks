package com.company.vTests.data;

import com.github.javafaker.Faker;

import java.util.Objects;

public class Location {
    private String locationName;
    private String country;
    private String city;
    private String address;
    private String phone;

    public Location() {
        this.locationName = Faker.instance().company().name();
        this.country = Faker.instance().country().name();
        this.city = Faker.instance().address().city();
        this.address = Faker.instance().address().fullAddress();
        this.phone = Faker.instance().phoneNumber().subscriberNumber(10);
    }

    public Location(String location,
                    String city,
                    String country,
                    String address,
                    String phone) {
        this.locationName = location;
        this.city = city;
        this.country = country;
        this.address = address;
        this.phone = phone;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationCity() {
        return city;
    }

    public String getLocationCountry() {
        return country;
    }

    public String getLocationAddress(){return address;}

    public String getLocationPhone(){return phone; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;
        if (!locationName.equals(location.locationName)) return false;
        if (!country.equals(location.country)) return false;
        if (!city.equals(location.city)) return false;
        if (!address.equals(location.address)) return false;
        return phone.equals(location.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationName, country, city, address, phone);
    }

}