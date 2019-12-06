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

public class User {

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("MiddleName")
    private String middleName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("DateOfBirth")
    private String dateOfBirth;

    @Override
    public String toString() {
        return "User[FirstName:" + firstName + "MiddleName:" + middleName + "LastName:" + lastName +
                ", ID: " + id + ", DateOfBirth: " + dateOfBirth + "]";
    }
}
