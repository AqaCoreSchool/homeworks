package oop;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        User aUser = new User("Andrew", 18, 15);
        List<Movie> films = aUser.getAllMovies();

        System.out.println(films);
        System.out.println(aUser.filterMovieByGenre(films,"Comedy"));
        System.out.println(aUser.isFilmDurationRespondsToFilter(films, 90));
        System.out.println(aUser.isReleaseOfAllFilmsRespondToCriteria(films, 2008));
        System.out.println(aUser.isFilmNameRespondsToCriteria(films, "Sunset Beach"));
        Collections.sort(films);
        System.out.println(films);





    }
}
