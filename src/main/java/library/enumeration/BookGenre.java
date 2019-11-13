package library.enumeration;

import java.util.Random;

public enum BookGenre {
    ADVENTURE,
    HORROR,
    HUMOR,
    NOVEL;

    public static BookGenre randomGenre() {
        int pick = new Random().nextInt(BookGenre.values().length);
        return BookGenre.values()[pick];
    }
}
