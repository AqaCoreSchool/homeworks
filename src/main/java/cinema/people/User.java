package cinema.people;

import cinema.Searchable;
import cinema.enums.Genre;
import cinema.enums.HallType;
import cinema.primary.Hall;
import cinema.primary.Movie;
import cinema.primary.Session;
import com.github.javafaker.Faker;

import java.util.*;

public class User extends Human implements Searchable {

    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    //This is override of "toString" method... he-he)) It's a joke)
    @Override
    public String toString() {
        return "User{" +
                "discount=" + discount +
                '}';
    }

    //This method creates and returns a List of all movies
    @Override
    public List<Movie> getAllMoviesList(){
        List<Movie> movies = new ArrayList<>();

        Hall hallOne = new Hall(1, HallType.IMAX, 60, 15.4);
        Hall hallTwo = new Hall(2, HallType.THREE_D, 80, 12.6);
        Hall hallThree = new Hall(3, HallType.TWO_D, 120, 10.7);
        Hall hallFour = new Hall(4, HallType.FIVE_D, 40, 16.3);

        Session firstSession = new Session(hallOne, 120.50, 12.00);
        Session secondSession = new Session(hallTwo, 80.00, 16.00);
        Session thirdSession = new Session(hallThree, 65.50, 18.00);
        Session fourSession = new Session(hallFour, 150.00, 20.00);

        movies.add(new Movie("Forrest Gump", Genre.DRAMA,
                1984, 108, 12, Arrays.asList(firstSession, secondSession)));
        movies.add(new Movie("Titanic", Genre.DRAMA,
                1995, 180, 12, Arrays.asList(firstSession, secondSession)));
        movies.add(new Movie("Terminator", Genre.ACTION,
                2002, 99, 16, Arrays.asList(secondSession, fourSession)));
        movies.add(new Movie("Untouchable", Genre.COMEDY,
                2011, 98, 12, Arrays.asList(secondSession, fourSession)));
        movies.add(new Movie("Rogue One", Genre.FANTASY,
                2017, 116, 16, Arrays.asList(secondSession, fourSession)));
        movies.add(new Movie("The LOtR", Genre.FANTASY,
                2006, 168, 12, Arrays.asList(firstSession, secondSession, thirdSession)));
        movies.add(new Movie("Schindler`s List", Genre.CRIMINAL,
                2002, 100, 16, Arrays.asList(firstSession, secondSession, thirdSession)));
        movies.add(new Movie("The Green Mile", Genre.DRAMA,
                2008, 92, 16, Arrays.asList(firstSession, secondSession, thirdSession)));
        movies.add(new Movie("The Godfather", Genre.CRIMINAL,
                1997, 145, 18, Arrays.asList(secondSession, thirdSession)));
        movies.add(new Movie("The Dark Knight", Genre.THRILLER,
                2015, 106, 16, Arrays.asList(secondSession, thirdSession)));
        movies.add(new Movie("The Matrix", Genre.FANTASY,
                2004, 121, 16, Arrays.asList(secondSession, thirdSession, fourSession)));
        movies.add(new Movie("Back to the Future", Genre.FANTASY,
                1995, 111, 12, Arrays.asList(secondSession, thirdSession, fourSession)));
        movies.add(new Movie("Gladiator", Genre.ACTION,
                2006, 86, 16, Arrays.asList(thirdSession, fourSession)));
        movies.add(new Movie("Avatar", Genre.FANTASY,
                2009, 140, 12, Arrays.asList(thirdSession, fourSession)));
        movies.add(new Movie("Aliens", Genre.FANTASY,
                1989, 98, 16, Arrays.asList(thirdSession, fourSession)));
        Collections.sort(movies);

        return movies;
    }


    //This method returns a Map with pairs: Movie - his Sessions
    @Override
    public Map<String, List<Session>> getAllSessionsOfAllMovies(List<Movie> films){
        Map<String, List<Session>> sessionMap = new HashMap<>();
        for(Movie elem: films){
            sessionMap.put(elem.getFilmName(),elem.getSessions());
        }
        return  sessionMap;
    }

    //This method returns a List of movies filtered by particular genre
    @Override
    public List<Movie> getMovieListFilteredByGenre(List<Movie> films, String genre){
        List<Movie> filteredMovie = new ArrayList<>();
        for(Movie elem: films){
            if(elem.getFilmGenre().toString().equalsIgnoreCase(genre)){
                filteredMovie.add(elem);
            }
        }
        return filteredMovie;
    }

    //This method checks if at least one movie in a List corresponds to search by duration
    @Override
    public boolean isOneFilmDurationCorrespondsToFilter(List<Movie> films, int duration){
        for(Movie elem: films){
            if(elem.getDuration() > duration){
                return true;
            }
        }
        return false;
    }

    //This method checks if all movies in a List corresponds to search by year of release
    public boolean isReleasesOfAllFilmsCorrespondToFilter(List<Movie> films, int yearRelease){
        for(Movie elem: films){
            if(elem.getYearRelease() < yearRelease){
                return false;
            }
        }
        return true;
    }

    //This method checks if movies in a List contain particular words in their names
    @Override
    public boolean isNamesOfFilmsContainWords(List<Movie> films, String filmName){
        for(Movie elem: films){
            if(elem.getFilmName().toLowerCase().contains(filmName.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    //This method returns Set of filtered unique genres
    @Override
    public Set<String> getAllUniqueGenresSet(List<Movie> films){
        Set<String> uniqueGenres = new HashSet<>();
        for(Movie elem: films){
            uniqueGenres.add(elem.getFilmGenre().toString());
        }
        return uniqueGenres;
    }
}
