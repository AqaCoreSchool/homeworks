package cinema;

import cinema.people.User;
import cinema.primary.Movie;

import java.util.*;
import static java.lang.String.join;


public class Main {

    public static void main(String[] args) {

        Searchable user = new User();
        ((User)user).setName("Andrew");
        ((User)user).setAge(25);
        ((User)user).setDiscount(10);

        List<Movie> films = user.getAllMoviesList();
        System.out.println(films);
        System.out.println(user.getAllSessionsOfAllMovies(films));
        System.out.println(user.getMovieListFilteredByGenre(films,"criminal"));
        System.out.println(user.isOneFilmDurationCorrespondsToFilter(films, 90));
        System.out.println(user.isReleasesOfAllFilmsCorrespondToFilter(films, 2008));
        System.out.println(user.isNamesOfFilmsContainWords(films, "mile"));
        System.out.println(join(", ", new TreeSet<>(user.getUniqueGenresSet(films))));
    }
}
