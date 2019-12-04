package ua.biz.test.entity;

public class Location {
    private String name;
    private String country;
    private String city;
    private int number;

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
}
