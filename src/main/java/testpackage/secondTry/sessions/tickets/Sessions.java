package testpackage.secondTry.sessions.tickets;


import testpackage.secondTry.base.BaseClass;
import testpackage.secondTry.cinema.Movie;
import testpackage.secondTry.entity.Film;
import testpackage.secondTry.factory.FilmFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sessions extends BaseClass {

    List<Film> filmList = getDefaultFilmList() ;

    public  List<Film>  getDefaultFilmList(){
        List<Film> filmList = Stream.of(FilmFactory.buildListFilm(Movie.JOKER),
               FilmFactory.buildListFilm(Movie.SHOPLIFTERS),
               FilmFactory.buildListFilm(Movie.ROCKETMAN),
               FilmFactory.buildListFilm(Movie.SHAZAM),
               FilmFactory.buildListFilm(Movie.US),
               FilmFactory.buildListFilm(Movie.MIDWAY),
               FilmFactory.buildListFilm(Movie.PARASITE),
               FilmFactory.buildListFilm(Movie.LIGHTHOUSE),
               FilmFactory.buildListFilm(Movie.ABOMINABLE),
               FilmFactory.buildListFilm(Movie.HUSTLERS),
               FilmFactory.buildListFilm(Movie.JUDY),
               FilmFactory.buildListFilm(Movie.TERMINATOR),
               FilmFactory.buildListFilm(Movie.MALEFICENT),
               FilmFactory.buildListFilm(Movie.HARRIET),
               FilmFactory.buildListFilm(Movie.COUNTDOWN)).collect(Collectors.toList());
        return filmList;
        
    }

    public void  uniqueGenresSortAlphabetically  (){
        Map<String, String> result1 = filmList.stream().collect(
                Collectors.toMap(x -> x.getNameFilm(), x -> x.getGenre()));
        TreeMap<String, String> reversedHashMap = new TreeMap<String, String>();

        for (String i : result1.keySet()) {
            reversedHashMap.put(result1.get(i), i);
        }
        for(Map.Entry<String, String> item : reversedHashMap.entrySet()){

            System.out.print(item.getKey()+" = "+item.getValue()+", ");
        }
    }

    public void printFilmList(){
        for(int i = 0;i<filmList.size();i++){
            System.out.println(filmList.get(i));
        }
    }

    public Sessions sortFilmsByGenre(String genre){
        filmList.removeIf(a ->(a.getGenre() != genre));

        return this;
    }

    public Sessions sortFilmsByAlphabetically(){
        Comparator<Film> comparator = Comparator.comparing(obj -> obj.getNameFilm());
        filmList.sort(comparator);
        return this;
    }

    public Boolean verifyIfOneOrAllOrNoOneMoviesHaveCriteria(String str) {
        int k = 0;
        for (int i = 0; i < filmList.size(); i++) {
            if (filmList.get(i).toString().contains(str) == true) {
                k++;
            }
        }
        if (k == filmList.size()) {
            System.out.println("All movies in your list corresponds to your criteria");
            return true;
        } else {
            if (k > 0) {
                System.out.println("One movie in your list corresponds to your criteria");
                return true;
            } else {
                if (k == 0) {
                    System.out.println("Not one movie on your list matches your criteria");
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}
