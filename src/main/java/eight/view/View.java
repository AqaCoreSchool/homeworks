package eight.view;

import eight.controller.Application;
import eight.exception.NoSuchGenreException;
import eight.exception.NoSuchTitleException;
import eight.exception.NotAYearException;
import eight.exception.UnsupportedDurationException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private Application application = new Application();
    private Scanner scanner = new Scanner(System.in);
    private boolean loop = true;

    public void showView() {
        System.out.print("1. Retrieve list of movie sessions\n" +
                "2.Retrieve list of movies filtered by particular genre\n" +
                "3.Sort all movies alphabetically\n" +
                "4.Check if at least one movie in your list corresponds to some search criteria\n" +
                "5.Check if all movies correspond to some search criteria\n" +
                "6.Check if none of the movies from list corresponds to some search criteria \n" +
                "7.Traverse movie list, collect all unique genres, sort them alphabetically and print " +
                "them to console using comma as a delimiter\nEnter any other key to exit.");

        while (loop) {
            try {
                System.out.print("\n\nMake your choise :");
                byte choise = scanner.nextByte();
                chooseOption(choise);

            } catch (InputMismatchException e) {
                System.out.println("Exception! Cause: " + e.getMessage());
                break;
            } catch (NoSuchGenreException | NoSuchTitleException | NotAYearException | UnsupportedDurationException e) {
                System.out.print("Exception! Cause: " + e.getMessage());
            }
        }
    }

    private void chooseOption(final byte choise) throws NoSuchGenreException, NotAYearException, UnsupportedDurationException, NoSuchTitleException {
        switch (choise) {
            case 1:
                application.showSessionList();
                break;
            case 2:
                System.out.print("Input genre: ");
                application.filterByGenre(scanner.next());
                break;
            case 3:
                application.sortMovies();
                break;
            case 4:
                System.out.print("Input duration: ");
                System.out.println(application.hasDurationMoreThen(scanner.nextDouble()));
                break;
            case 5:
                System.out.print("Input year: ");
                System.out.println(application.hasYearMoreThan(scanner.nextInt()));
                break;
            case 6:
                System.out.print("Input title: ");
                System.out.println(application.hasTitleLike(scanner.next()));
                break;
            case 7:
                application.collectUniqueGenres();
                break;
            default:
                System.out.println("Exiting...");
                loop = false;
        }
    }
}
