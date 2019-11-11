package oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Titanic extends Movie {
    private String nameOfMovie;
    private int yearOfRelease;
    private int movieDuration;
    private String movieGenre;
    private List<String> sessions = new ArrayList<>(Arrays.asList("16:00", "20:00"));

    public Titanic(String nameOfMovie, int yearOfRelease, int movieDuration, String movieGenre) {
        this.nameOfMovie = nameOfMovie;
        this.yearOfRelease = yearOfRelease;
        this.movieDuration = movieDuration;
        this.movieGenre = movieGenre;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public void setNameOfMovie(String nameOfMovie) {
        this.nameOfMovie = nameOfMovie;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public List<String> getSessions() {
        return sessions;
    }

    public void setSessions(List<String> sessions) {
        this.sessions = sessions;
    }

    @Override
    public void getSession() {
        for (String elem: sessions){
            System.out.println(elem);
        }
        int time = scan.nextInt();
        if(time==1){
            System.out.println("You have booked a " + nameOfMovie + " movie ticket." +
                                "\nThe session will begin at " + sessions.get(0));
        }else{
            System.out.println("You have booked a " + nameOfMovie + " movie ticket." +
                                "\nThe session will begin at " + sessions.get(1));
        }

    }

    @Override
    public Object getDate() {
        System.out.println("Please enter a date in the format: 10.11.2019");
        String date = scan.nextLine();
        boolean name = date.matches("^[0-9]{2}.[0-9]{2}.[0-9]{4}$");
        if(name == true){
            System.out.println("Also specify the session number: 1 або 2");
        }
        else{
            System.out.println("Please enter the date in the correct format");
        }
        getSession();
        return null;
    }
}
