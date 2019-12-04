package testpackage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Location {

    private String name;

    private String country;

    private String city;

    private String address;

    private String postalCode;

    private String phoneNumber;

}
