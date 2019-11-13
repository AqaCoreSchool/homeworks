package testpackage.factory;

import testpackage.base.BaseClass;
import testpackage.entity.Film;
import testpackage.cinema.Movie;

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
