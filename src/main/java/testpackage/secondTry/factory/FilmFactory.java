package testpackage.secondTry.factory;



import testpackage.secondTry.base.BaseClass;
import testpackage.secondTry.entity.Film;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FilmFactory extends BaseClass {

    public static List<Film> getDefaultFilmList(){
        return Stream.of(
                Film.builder()
                        .nameFilm("Joker")
                        .description("The origin tale of the Joker (Joaquin Phoenix) " +
                                "– one of the most iconic villains in comic book history.")
                        .genre("Thriller")
                        .session(new String[]{"16:00", "18:00", "22:00"})
                        .voiceLanguage("English")
                        .format("3D")
                        .ageLimit(16)
                        .build(),

                Film.builder()
                        .nameFilm("Shoplifters")
                        .description("When Osamu Shibata finds five-year-old Yuri on the streets, " +
                                "cold and starving on a winter night, he brings her home to feed her.")
                        .genre("Drama")
                        .session(new String[]{"12:00", "15:00", "22:00"})
                        .voiceLanguage("Ukraine")
                        .format("5D")
                        .ageLimit(12)
                        .build(),

                Film.builder()
                        .nameFilm("Rocketman")
                        .description("An epic musical fantasy about the incredible " +
                                "story of Elton John's breakthrough years.")
                        .genre("Biography")
                        .session(new String[]{"13:00", "15:00", "21:00"})
                        .voiceLanguage("English")
                        .format("2D")
                        .ageLimit(16)
                        .build(),

                Film.builder()
                        .nameFilm("Shazam")
                        .description("We all have a superhero inside us," +
                                " it just takes a bit of magic to bring it out.")
                        .genre("Adventure")
                        .session(new String[]{"10:00", "13:00", "17:00"})
                        .voiceLanguage("Ukraine")
                        .format("2D")
                        .ageLimit(12)
                        .build(),

                Film.builder()
                        .nameFilm("Us")
                        .description("A family's serene beach vacation turns to chaos " +
                                "when their doppelgängers appear and begin to terrorize them.")
                        .genre("Horror")
                        .session(new String[]{"09:00", "19:00", "21:00"})
                        .voiceLanguage("English")
                        .format("5D")
                        .ageLimit(18)
                        .build(),

                Film.builder()
                        .nameFilm("Midway")
                        .description("The story of the Battle of Midway, " +
                                "told by the leaders and the sailors who fought it.")
                        .genre("Action")
                        .session(new String[]{"11:00", "15:00", "23:00"})
                        .voiceLanguage("Ukraine")
                        .format("3D")
                        .ageLimit(16)
                        .build())

                .collect(toList());
    }

}
