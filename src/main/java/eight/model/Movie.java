package eight.model;

import java.time.LocalTime;

public class Movie {
    private LocalTime session;
    private String title;
    private String genre;
    private double duration;
    private int year;

    public Movie(LocalTime sessions, String title, String genre, double duration, int year) {
        this.session = sessions;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.year = year;
    }

    public LocalTime getSession() {
        return session;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getDuration() {
        return duration;
    }

    public int getYear() {
        return year;
    }
}
