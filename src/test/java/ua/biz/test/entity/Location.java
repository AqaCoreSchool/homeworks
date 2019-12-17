package ua.biz.test.entity;

import java.util.Objects;

public class Location {
    private String name;
    private String country;
    private String city;
    private int number;

    public Location() {
    }

    public Location(String name, String country, String city, int number) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return number == location.number &&
                Objects.equals(name, location.name) &&
                Objects.equals(country, location.country) &&
                Objects.equals(city, location.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, city, number);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", number=" + number +
                '}';
    }
}
