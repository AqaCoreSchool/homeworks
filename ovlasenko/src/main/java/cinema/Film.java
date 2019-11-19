package cinema;

import cinema.enumeration.FilmCountry;
import cinema.enumeration.FilmGenre;

public abstract class Film {

    private String name;
    private FilmGenre filmGenre;
    private FilmCountry country;
    private double year;

    public Film(String name, FilmGenre filmGenre, FilmCountry country, int year) {
        this.name = name;
        this.filmGenre = filmGenre;
        this.country = country;
        this.year = year;
    }

    public Film() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FilmGenre getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(FilmGenre filmGenre) {
        this.filmGenre = filmGenre;
    }

    public FilmCountry getCountry() {
        return country;
    }

    public void setCountry(FilmCountry country) {
        this.country = country;
    }


    public void setYear(int year) { this.year = year; }

    public double getYear() { return year; }
}
