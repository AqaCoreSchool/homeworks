package main.java.cinema.model;

public class Address {
    private String city;
    private String streetName;
    private String streetNumber;

    public Address(String city, String streetName, String streetNumber) {
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }


    @Override
    public String toString() {
        return "Address{" +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }
}
