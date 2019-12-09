package testpackage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Candidate {

    private String firstName ;

    private String middleName ;

    private String lastName;

    private String email;

    private String date ;

    private String phoneNumber;

    private String vacancy ;

    private String resume;

}
