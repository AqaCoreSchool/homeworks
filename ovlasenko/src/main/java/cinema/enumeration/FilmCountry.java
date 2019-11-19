package cinema.enumeration;

import java.util.Random;

public enum FilmCountry {
    USA,
    UK,
    INDIA,
    UKARINE,
    GERMANY;

    public static FilmCountry randomFilmCountry() {
        int pick = new Random().nextInt(FilmCountry.values().length);
        return FilmCountry.values()[pick];
    }
}
