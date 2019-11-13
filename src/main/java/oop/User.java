package oop;

import java.util.*;

public class User extends Cinema {
    private String name;
    private int age;
    private int discount;

    public User(String name, int age, int discount) {
        this.name = name;
        this.age = age;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", discount=" + discount +
                '}';
    }

    public List<Movie> getAllMovies(){
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

    public List<Movie> filterMovieByGenre(List<Movie> films, String genre){
        List<Movie> filteredMovie = new ArrayList<>();
        for(Movie elem: films){
            if(elem.getFilmGenre().equals(genre.toLowerCase())){
                filteredMovie.add(elem);
            }

        }

        return filteredMovie;
    }

    public boolean isFilmDurationRespondsToFilter(List<Movie> films, int duration){
       for(Movie elem: films){
            if(elem.getDuration() > duration){
                return true;
            }
        }
        return false;
    }

    public boolean isReleaseOfAllFilmsRespondToCriteria(List<Movie> films, int yearRelease){
        for(Movie elem: films){
            if(elem.getYearRelease() < yearRelease){
                return false;
            }
        }
        return true;
    }

    public boolean isFilmNameRespondsToCriteria(List<Movie> films, String filmName){
        for(Movie elem: films){
            if(elem.getFilmName() == filmName.toLowerCase()){
                return true;
            }
        }
        return false;
    }


}
