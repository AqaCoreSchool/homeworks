package cinema.people;

import cinema.Searchable;
import cinema.enums.Genre;
import cinema.enums.HallType;
import cinema.exception.NoSuchFilmsException;
import cinema.primary.Hall;
import cinema.primary.Movie;
import cinema.primary.Session;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public int getRandomValue(int x, int y){
        Faker faker = new Faker();
        return faker.random().nextInt(x,y);
    }

    //This method creates and returns a List of all movies
    @Override
    public List<Movie> getAllMoviesList(){
        Faker faker = new Faker();

        Hall hallOne = new Hall(1, HallType.IMAX, 60, 15.4);
        Hall hallTwo = new Hall(2, HallType.THREE_D, 80, 12.6);
        Hall hallThree = new Hall(3, HallType.TWO_D, 120, 10.7);
        Hall hallFour = new Hall(4, HallType.FIVE_D, 40, 16.3);

        List<Session> sessions;
        sessions = Arrays.asList(new Session(hallOne, 120.50, LocalTime.of(12, 15), LocalDate.now()),
                new Session(hallTwo, 80.00, LocalTime.of(15, 45), LocalDate.now()),
                new Session(hallThree, 65.50, LocalTime.of(18, 00), LocalDate.now()),
                new Session(hallFour, 150.00, LocalTime.of(21,30), LocalDate.now()));

        List<String> movieNames = new ArrayList<>(Arrays.asList("Forrest Gump", "Titanic", "Terminator",
                "Untouchable", "Rogue One", "The LOtR", "Schindlers List", "Green Mile", "Godfather",
                "Dark Knight", "Matrix", "Back to the Future", "Gladiator", "Avatar", "Aliens"));

        List<Movie> movies =movieNames.stream()
                .map(p->new Movie(p, Genre.values()[getRandomValue(0,5)], getRandomValue(1984, 2019),
                        getRandomValue(85, 200), getRandomValue(12, 18),
                        sessions.subList(getRandomValue(0, 2),getRandomValue(2,4))))
                .sorted()
                .collect(Collectors.toList());
        return movies;
    }

    //This method returns a Map with pairs: Movie - his Sessions
    @Override
    public Map<String, List<Session>> getAllSessionsOfEnteredMovies(List<Movie> films, String filmName) {

        Map<String, List<Session>> sessionMap = films.stream()
                .filter(m -> m.getFilmName().equalsIgnoreCase(filmName))
                .collect(Collectors.toMap(Movie::getFilmName, Movie::getSessions));
        if (sessionMap.isEmpty()) {
            throw new NoSuchFilmsException("Our collection of films doesn't include entered film. " +
                                            "Check your spelling or try another.");
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

