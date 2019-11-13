package testpackage.secondTry.factory;

import testpackage.secondTry.base.BaseClass;
import testpackage.secondTry.entity.User;
import testpackage.secondTry.sessions.tickets.Sessions;

public class UserFactory extends BaseClass {
    public static Sessions createNewUser(String firstName, String lastName, String birthDate,
                                         String email, String preferebleFilmLanguage){
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .email(email)
                .preferFilmLanguage(preferebleFilmLanguage)
                .build();
        return new Sessions();
    }

    public static User getUserByEmail(String email){
        return new User();
    }

}
