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

public class Candidate {

    @JsonProperty("FirstName")
    private String firstName ;

    @JsonProperty("MiddleName")
    private String middleName ;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Date")
    private String date ;

    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @JsonProperty("Vacancy")
    private String vacancy ;

    @JsonProperty("Resume")
    private String resume;
    
    @Override
    public String toString() {
        return "Candidate[FirstName:" + firstName + ", MiddleName:" + middleName + ", LastName:" + lastName +
                ", Email: " + email + ", Date: " + date + ", PhoneNumber: " + phoneNumber
                + ", Vacancy: " + vacancy + ", Resume: " + resume + "]";
    }
}
