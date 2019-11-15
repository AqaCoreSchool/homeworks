package cinema;


import cinema.primary.Hall;
import cinema.primary.Movie;
import cinema.primary.Session;

import java.util.*;

public interface Searchable {

    //This method creates and returns a list of all movies
    default List<Movie> getAllMoviesList(){
        List<Movie> movies = new ArrayList<>();
        Hall hallOne = new Hall(1, "Imax", 60, 15.4);
        Hall hallTwo = new Hall(2, "3D", 80, 12.6);
        Hall hallThree = new Hall(3, "2D", 120, 10.7);
        Hall hallFour = new Hall(4, "5D", 40, 16.3);

        Session firstSession = new Session(hallOne, 120.50, 12.00);
        Session secondSession = new Session(hallTwo, 80.00, 16.00);
        Session thirdSession = new Session(hallThree, 65.50, 18.00);
        Session fourSession = new Session(hallFour, 150.00, 20.00);

        movies.add(new Movie("Forrest Gump", "drama",
                1984, 108, 12, Arrays.asList(firstSession, secondSession)));
        movies.add(new Movie("Titanic", "drama",
                1995, 180, 12, Arrays.asList(firstSession, secondSession)));
        movies.add(new Movie("Terminator", "action",
                2002, 99, 16, Arrays.asList(secondSession, fourSession)));
        movies.add(new Movie("Untouchable", "comedy",
                2011, 98, 12, Arrays.asList(secondSession, fourSession)));
        movies.add(new Movie("Rogue One", "fantasy",
                2017, 116, 16, Arrays.asList(secondSession, fourSession)));
        movies.add(new Movie("The LOtR", "fantasy",
                2006, 168, 12, Arrays.asList(firstSession, secondSession, thirdSession)));
        movies.add(new Movie("Schindler`s List", "criminal",
                2002, 100, 16, Arrays.asList(firstSession, secondSession, thirdSession)));
        movies.add(new Movie("The Green Mile", "drama",
                2008, 92, 16, Arrays.asList(firstSession, secondSession, thirdSession)));
        movies.add(new Movie("The Godfather", "criminal",
                1997, 145, 18, Arrays.asList(secondSession, thirdSession)));
        movies.add(new Movie("The Dark Knight", "thriller",
                2015, 106, 16, Arrays.asList(secondSession, thirdSession)));
        movies.add(new Movie("The Matrix", "fantasy",
                2004, 121, 16, Arrays.asList(secondSession, thirdSession, fourSession)));
        movies.add(new Movie("Back to the Future", "comedy",
                1995, 111, 12, Arrays.asList(secondSession, thirdSession, fourSession)));
        movies.add(new Movie("Gladiator", "action",
                2006, 86, 16, Arrays.asList(thirdSession, fourSession)));
        movies.add(new Movie("Avatar", "fantasy",
                2009, 140, 12, Arrays.asList(thirdSession, fourSession)));
        movies.add(new Movie("Aliens", "fantasy",
                1989, 98, 16, Arrays.asList(thirdSession, fourSession)));
        Collections.sort(movies);

        return movies;
    }

    //This method returns a Map with pairs: Movie - his Sessions
    default Map<String, List<Session>> getAllSessionsOfAllMovies(List<Movie> films){
        Map<String, List<Session>> sessionMap = new HashMap<>();
        for(Movie elem: films){
            sessionMap.put(elem.getFilmName(),elem.getSessions());
        }
        return  sessionMap;
    }

    //This method returns a List of movies filtered by particular genre
    default List<Movie> getMovieListFilteredByGenre(List<Movie> films, String genre){
        List<Movie> filteredMovie = new ArrayList<>();
        for(Movie elem: films){
            if(elem.getFilmGenre().equalsIgnoreCase(genre)){
                filteredMovie.add(elem);
            }
        }
        return filteredMovie;
    }

    //This method checks if at least one movie in a list corresponds to search by duration
    default boolean isOneFilmDurationCorrespondsToFilter(List<Movie> films, int duration){
        for(Movie elem: films){
            if(elem.getDuration() > duration){
                return true;
            }
        }
        return false;
    }

    //This method checks if all movies in a list corresponds to search by year of release
    default boolean isReleasesOfAllFilmsCorrespondToFilter(List<Movie> films, int yearRelease){
        for(Movie elem: films){
            if(elem.getYearRelease() < yearRelease){
                return false;
            }
        }
        return true;
    }

    //This method checks if movies in a list contain particular words in their names
    default boolean isNamesOfFilmsContainWords(List<Movie> films, String filmName){
        for(Movie elem: films){
            if(elem.getFilmName().toLowerCase().contains(filmName.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    //This method
    default Set<String> getUniqueGenresSet(List<Movie> films){
        Set<String> uniqueGenres = new HashSet<>();
        for(Movie elem: films){
            uniqueGenres.add(elem.getFilmGenre());
        }
        return uniqueGenres;
    }
}
