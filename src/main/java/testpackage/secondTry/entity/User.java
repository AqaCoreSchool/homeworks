package testpackage.secondTry.entity;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String userName;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String email;

    private String typeOfSubscription;

    private String preferebleFilmLanguage;

}
