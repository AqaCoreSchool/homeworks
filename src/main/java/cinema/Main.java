package cinema;

import cinema.people.User;
import cinema.primary.Movie;

import java.util.*;
import static java.lang.String.join;


public class Main {

    public static void main(String[] args) {

        User aUser = new User();
        aUser.setName("Andrew");
        aUser.setAge(25);
        aUser.setDiscount(10);

        List<Movie> films = aUser.getAllMoviesList();
        System.out.println(films);
        System.out.println(aUser.getAllSessionsOfAllMovies(films));
        System.out.println(aUser.getMovieListFilteredByGenre(films,"criminal"));
        System.out.println(aUser.isOneFilmDurationCorrespondsToFilter(films, 90));
        System.out.println(aUser.isReleasesOfAllFilmsCorrespondToFilter(films, 2008));
        System.out.println(aUser.isNamesOfFilmsContainWords(films, "mile"));
        System.out.println(join(", ", new TreeSet<>(aUser.getAllUniqueGenresSet(films))));
    }
}
