package library.enumeration;

import java.util.Random;

public enum BookLanguage {
    ENGLISH,
    UKRAINIAN,
    RUSSIAN,
    GERMAN;

    public static BookLanguage randomLanguage() {
        int pick = new Random().nextInt(BookLanguage.values().length);
        return BookLanguage.values()[pick];
    }
}
