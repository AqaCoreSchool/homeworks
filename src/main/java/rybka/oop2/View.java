package rybka.oop2;

import java.util.Scanner;

public class View {
    private Application application = new Application();
    private Scanner scanner = new Scanner(System.in);

    public void showView() {
        System.out.print("1. Retrieve list of movie sessions\n" +
                "2.Retrieve list of movies filtered by particular genre\n" +
                "3.Sort all movies alphabetically\n" +
                "4.Check if at least one movie in your list corresponds to some search criteria\n" +
                "5.Check if all movies correspond to some search criteria\n" +
                "6.Check if none of the movies from list corresponds to some search criteria \n" +
                "7.Traverse movie list, collect all unique genres, sort them alphabetically and print " +
                "them to console using comma as a delimiter\nEnter any other key to exit.");

        boolean loop = true;
        while (loop) {
            System.out.println("\n\nMake your choise :");
            byte choice = scanner.nextByte();

            switch (choice) {
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
                    System.out.println(application.isAtLeastOneMovie(scanner.nextDouble()));
                    break;
                case 5:
                    System.out.print("Input year: ");
                    System.out.println(application.isAllMovies(scanner.nextInt()));
                    break;
                case 6:
                    System.out.print("Input title: ");
                    System.out.println(application.isNoneMovies(scanner.next()));
                    break;
                case 7:
                    application.collectUniqueGenres();
                    break;
                default:
                    loop = false;
            }
        }
    }
}
