package library.enumeration;

import java.util.Random;

public enum BookAuthor {
    TARAS_SHEVCHENKO,
    IVAN_KOTLYAREVSKY,
    IVAN_FRANKO,
    MYKHAILO_KOTSIUBYNSKY,
    LESYA_UKRAINKA;

    public static BookAuthor randomAuthor() {
        int pick = new Random().nextInt(BookAuthor.values().length);
        return BookAuthor.values()[pick];
    }
}
