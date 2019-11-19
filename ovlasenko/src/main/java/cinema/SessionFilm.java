package cinema;

import cinema.enumeration.CinemaCategory;
import cinema.enumeration.FilmCountry;
import cinema.enumeration.FilmGenre;

public class SessionFilm extends Film{

    private float duration;
    private CinemaCategory category;
    private float price;

    public SessionFilm(String name, FilmGenre genre, FilmCountry country, double year, CinemaCategory category) {
    }

    public SessionFilm(String name, FilmGenre filmGenre, FilmCountry country,
                       int year, float duaration, CinemaCategory category, float price ) {
        super(name, filmGenre, country, year);
        this.duration = duaration;
        this.category = category;
        this.price = price;
    }

    public SessionFilm(String name, FilmGenre filmGenre, FilmCountry country,
                    int year ) {
        super(name, filmGenre, country, year);
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duaration) {
        this.duration = duaration;
    }


}
