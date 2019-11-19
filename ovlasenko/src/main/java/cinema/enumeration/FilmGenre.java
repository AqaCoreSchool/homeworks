package cinema.enumeration;

import java.util.Random;

public enum FilmGenre {
    COMEDY,
    DRAMA,
    FANTASY,
    HORROR,
    THRILLER;

    public static FilmGenre randomFilmGenre() {
        int pick = new Random().nextInt(FilmGenre.values().length);
        return FilmGenre.values()[pick];
    }
}
