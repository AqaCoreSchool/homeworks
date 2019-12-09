package lombok.random;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@Getter @Setter
public class LocationRand {

    private String locationName;
    private String country;
    private String province;
    private String city;
    private String address;
    private String postalCode;
    private String phone;
}
