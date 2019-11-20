package testpackage;

import testpackage.factory.UserFactory;
import testpackage.sessions.tickets.Sessions;

public class Application {
    public static void main(String[] args)  {

        Sessions user = UserFactory.createNewUser("Danya","Pazykov","12.12.2012",
                "kapdpadp@gmail.com","English");
        user.uniqueGenresSortAlphabetically();
        System.out.println("\n");
        user.printFilmList(user.getDefaultFilmList());
        System.out.println("\n");
        user.haveAllMovieCriteria("genre");
        System.out.println("\n");
        user.printFilmsByGenre("Horror");
        System.out.println("\n");
        user.printFilmsByAlphabetically();
        System.out.println("\n");
        user.printFilmsByDate();

    }
}