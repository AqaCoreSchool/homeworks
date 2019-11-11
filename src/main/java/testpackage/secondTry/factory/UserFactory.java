package testpackage.secondTry.factory;



import testpackage.secondTry.base.BaseClass;
import testpackage.secondTry.entity.User;

import java.util.Date;

public class UserFactory extends BaseClass {
    public static User createNewUser(String firstName, String lastName, Date birthDate,
                                     String email, String preferebleFilmLanguage){
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .email(email)
                .preferebleFilmLanguage(preferebleFilmLanguage)
                .build();
    }

    public static User getUserByEmail(String email){
        return new User();
    }

}
