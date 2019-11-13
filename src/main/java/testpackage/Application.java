package testpackage;

import testpackage.factory.UserFactory;
import testpackage.sessions.tickets.Sessions;

public class Application {
    public static void main(String[] args)  {

        Sessions user = UserFactory.createNewUser("Danya","Pazykov","12.12.2012",
                "kapdpadp@gmail.com","English");
        user.uniqueGenresSortAlphabetically();
        System.out.println("\n");
        user.getDefaultFilmList();
        user.sortFilmsByAlphabetically().printFilmList();
        System.out.println("\n");
        user.hasOneMovieCriteria("Horror");
        System.out.println("\n");
        user.sortFilmsByGenre("Horror").printFilmList();
    }
}
