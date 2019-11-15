package rybka.oop2;

public class Movie {
    private String sessions;
    private String title;
    private String genre;
    private double duration;
    private int year;

    Movie(String sessions, String title, String genre, double duration, int year) {
        this.sessions = sessions;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.year = year;
    }

    String getSessions() {
        return sessions;
    }

    String getTitle() {
        return title;
    }

    String getGenre() {
        return genre;
    }

    double getDuration() {
        return duration;
    }

    int getYear() {
        return year;
    }
}
