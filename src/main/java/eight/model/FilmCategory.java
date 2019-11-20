package eight.model;

import java.util.Random;

public enum FilmCategory {
    ACTION,
    COMEDY,
    DRAMA,
    HORROR,
    THRILLER,
    FANTASY;

    public static String getRandomCategory() {
        return values()[new Random().nextInt(FilmCategory.values().length)].name();
    }
}
