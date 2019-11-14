package cinema.enumeration;

import java.util.Random;

public enum CinemaCategory {
    THREED,
    IMAX,
    TWOD,
    FIVED;

    public static CinemaCategory randomCinemaCategory() {
        int pick = new Random().nextInt(CinemaCategory.values().length);
        return CinemaCategory.values()[pick];
    }

}
