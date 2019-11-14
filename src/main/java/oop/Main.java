package oop;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        User aUser = new User("Andrew", 18, 15);
        List<Movie> films = aUser.getAllMovies();

        System.out.println(films);
        System.out.println(aUser.getMovieListFilteredByGenre(films,"Comedy"));
        System.out.println(aUser.isFilmDurationRespondsToFilter(films, 90));
        System.out.println(aUser.isReleasesOfAllFilmsRespondToCriteria(films, 2008));
        System.out.println(aUser.isNoneOfFilmsRespondsToCriteria(films, "mile"));
        System.out.println(aUser.getMovieSetWithUniqueGenres(films));
        System.out.println(aUser.getAllSessionsOfAllFilms(films));

        //work in progress...
        Set<Movie> uniqueMoviesByGenre = aUser.getMovieSetWithUniqueGenres(films);
        for (Movie elem: uniqueMoviesByGenre){
            System.out.print(elem + " /// ");
        }
    }
}
