package cinema.people;

import cinema.Searchable;
import cinema.enums.Genre;
import cinema.enums.HallType;
import cinema.exception.NoSuchFilmsException;
import cinema.primary.Hall;
import cinema.primary.Movie;
import cinema.primary.Session;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Faker faker = new Faker();

        Hall hallOne = new Hall(1, HallType.IMAX, 60, 15.4);
        Hall hallTwo = new Hall(2, HallType.THREE_D, 80, 12.6);
        Hall hallThree = new Hall(3, HallType.TWO_D, 120, 10.7);
        Hall hallFour = new Hall(4, HallType.FIVE_D, 40, 16.3);

        Session firstSession = new Session(hallOne, 120.50, 12.00);
        Session secondSession = new Session(hallTwo, 80.00, 16.00);
        Session thirdSession = new Session(hallThree, 65.50, 18.00);
        Session fourSession = new Session(hallFour, 150.00, 20.00);

        List<String> movieNames = new ArrayList<>(Arrays.asList("Forrest Gump", "Titanic", "Terminator",
                "Untouchable", "Rogue One", "The LOtR", "Schindler`s List", "Green Mile", "Godfather",
                "Dark Knight", "Matrix", "Back to the Future", "Gladiator", "Avatar", "Aliens"));

        List<Movie> movies =movieNames.stream()
                .map(p->new Movie(p, Genre.values()[faker.random().nextInt(0,5)], faker.random().nextInt(1985,2019),
                        faker.random().nextInt(85, 200), faker.random().nextInt(12,18),
                        Arrays.asList(firstSession, secondSession)))
                .sorted()
                .collect(Collectors.toList());
        return movies;
    }


    //This method returns a Map with pairs: Movie - his Sessions
    @Override
    public Map<String, List<Session>> getAllSessionsOfAllMovies(List<Movie> films) {

        Map<String, List<Session>> sessionMap = films.stream()
                .collect(Collectors.toMap(Movie::getFilmName, Movie::getSessions));
        if (sessionMap.isEmpty()) {
            throw new NoSuchFilmsException("Our collection of films doesn't include any films with sessions");
        }
        return sessionMap;
    }



    //This method returns a List of movies filtered by particular genre
    @Override
    public List<Movie> getMovieListFilteredByGenre(List<Movie> films, String genre) {

        List<Movie> filteredMovie = films.stream()
                .filter(p -> p.getFilmGenre().toString().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
        if (filteredMovie.isEmpty()){
            throw new NoSuchFilmsException("Our collection of films doesn't include " +
                    "films with this genre - " + genre);
        }
        return filteredMovie;
    }

    //This method checks if at least one movie in a List corresponds to search by duration
    @Override
    public boolean isOneFilmDurationCorrespondsToFilter(List<Movie> films, int duration){

        return (films.stream()
                .anyMatch(s->s.getDuration()>duration));
    }

    //This method checks if all movies in a List corresponds to search by year of release
    public boolean isReleasesOfAllFilmsCorrespondToFilter(List<Movie> films, int yearRelease) {
        if (yearRelease < 1984) {
            throw new NoSuchFilmsException("Our collection of films doesn't include films" +
                    " with release in - " + yearRelease + " Try searching after - 1984");
        }
        return (films.stream()
                .allMatch(s -> s.getDuration() < yearRelease));

    }
    //This method checks if movies in a List contain particular words in their names
    @Override
    public boolean isNoneOfFilmsContainWords(List<Movie> films, String filmName){

        return (films.stream()
                .noneMatch(s->s.getFilmName().toLowerCase().contains(filmName.toLowerCase())));
    }

    //This method returns Set of filtered unique genres
    @Override
    public Set<String> getAllUniqueGenresSet(List<Movie> films){
        Set<String> uniqueGenres = films.stream()
                .map(p->p.getFilmGenre().toString())
                .collect(Collectors.toSet());
        if (uniqueGenres.isEmpty()) {
            throw new NoSuchFilmsException("Our collection of films doesn't include any films with unique genres");
        }
        return uniqueGenres;
    }
}

