package testpackage.secondTry.sessions.tickets;



import testpackage.secondTry.base.BaseClass;
import testpackage.secondTry.films.Film;

import java.util.Arrays;

public class Sessions extends BaseClass {


    public void getInformationAboutFilm(){
    }

    public void getFilmsByGenre(){

    }

    public void getAllFilms(){
        System.out.println(Arrays.toString(Film.values()));
    }
}
