package cinema;


import cinema.primary.Hall;
import cinema.primary.Movie;
import cinema.primary.Session;

import java.util.*;

public interface Searchable {

    List<Movie> getAllMoviesList();

    Map<String, List<Session>> getAllSessionsOfAllMovies(List<Movie> films);

    List<Movie> getMovieListFilteredByGenre(List<Movie> films, String genre);

    boolean isOneFilmDurationCorrespondsToFilter(List<Movie> films, int duration);

    boolean isReleasesOfAllFilmsCorrespondToFilter(List<Movie> films, int yearRelease);

    boolean isNamesOfFilmsContainWords(List<Movie> films, String filmName);

    Set<String> getAllUniqueGenresSet(List<Movie> films);
}