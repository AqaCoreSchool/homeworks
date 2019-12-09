package testpackage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private String firstName;

    private String middleName;

    private String lastName;

    private String id;

    private String dateOfBirth;
}
