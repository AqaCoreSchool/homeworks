package testpackage.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Location {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("City")
    private String city;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @Override
    public String toString() {
        return "Location[Name:" + name + ", Country: " + country + ", City: " + city + ", Address: " + address
                + ", PostalCode: " + postalCode + ", PhoneNumber: " + phoneNumber + "]";
    }
}
