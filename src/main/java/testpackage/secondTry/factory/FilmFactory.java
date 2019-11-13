package testpackage.secondTry.factory;

import testpackage.secondTry.base.BaseClass;
import testpackage.secondTry.cinema.Movie;
import testpackage.secondTry.entity.Film;

public class FilmFactory extends BaseClass {

    public static Film buildListFilm(Movie.Films films){
          Film film = Film.builder()
                .nameFilm(films.getNameFilm())
                .description(films.getDescription())
                .genre(films.getGenre())
                .session(films.getSession())
                .voiceLanguage(films.getVoiceLanguage())
                .format(films.getFormat())
                .ageLimit(films.getAgeLimit())
                .build();
          return film;
    }

}
