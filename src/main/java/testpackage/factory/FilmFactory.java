package testpackage.factory;

import testpackage.base.BaseClass;
import testpackage.cinema.Movie;
import testpackage.entity.Film;
import testpackage.entity.Film;
import testpackage.cinema.Movie;

public class FilmFactory extends BaseClass {

    public static Film buildListFilm(Movie films){
          Film film = Film.builder()
                .nameFilm(films.getNameFilm())
                .description(films.getDescription())
                .genre(films.getGenre())
                .session(films.getSession())
                .voiceLanguage(films.getVoiceLanguage())
                .format(films.getFormat())
                .ageLimit(films.getAgeLimit())
                  .date(films.getDate())
                .build();
          return film;
    }

}
