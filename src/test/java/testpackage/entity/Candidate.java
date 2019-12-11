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

    private String empNumber ;

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

    Vacancy vacanc;
    
    @Override
    public String toString() {
        return String.format("Employee [emp_number: %s| first_name: %s\t| last_name: %s| hiring_manager_id: %s| name=%s",
                empNumber, firstName, lastName, vacanc.getHiringManagerID(), vacanc.getName());
    }
}
