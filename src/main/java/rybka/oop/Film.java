package rybka.oop;

import rybka.oop.Cinema;

public class Film {
    private String title;
    private Cinema cinema;

    public Film(String title, Cinema cinema) {
        this.title = title;
        this.cinema = cinema;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
