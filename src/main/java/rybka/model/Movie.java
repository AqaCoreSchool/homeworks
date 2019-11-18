package rybka.model;

public class Movie {
    private String sessions;
    private String title;
    private String genre;
    private double duration;
    private int year;

    public Movie(String sessions, String title, String genre, double duration, int year) {
        this.sessions = sessions;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.year = year;
    }

    public String getSessions() {
        return sessions;
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
