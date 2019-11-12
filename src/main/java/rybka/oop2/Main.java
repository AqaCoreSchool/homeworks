package rybka.oop2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Application application = new Application();
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. Retrieve list of movie sessions\n" +
                "2.Retrieve list of movies filtered by particular genre\n" +
                "3.Sort all movies alphabetically\n" +
                "4.Check if at least one movie in your list corresponds to some search criteria\n" +
                "5.Check if all movies correspond to some search criteria\n" +
                "6.Check if none of the movies from list corresponds to some search criteria \n" +
                "7.Traverse movie list, collect all unique genres, sort them alphabetically and print them to console using comma as a delimiter\n\n" +
                "Make your choise : ");

        byte choice = scanner.nextByte();

        switch (choice) {
            case 1: {
                application.showSessionList();
                break;
            }
            case 2: {
                System.out.print("Input genre: ");
                application.filterByGenre(scanner.next());
                break;
            }
            case 3: {
                application.sortMovies();
                break;
            }
            case 4: {
                System.out.print("Input duration: ");
                application.checkIfAtLeastOneMovie(scanner.nextDouble());
                break;
            }
            case 5: {
                System.out.print("Input year: ");
                application.checkIfAllMovies(scanner.nextInt());
                break;
            }
            case 6: {
                System.out.print("Input title: ");
                application.checkIfNoneMovies(scanner.next());
                break;
            }
            case 7: {
                application.collectUniqueGenres();
                break;
            }
            default: {
                System.out.println("Wrong choice. Please try again.");
            }
        }

    }
}
