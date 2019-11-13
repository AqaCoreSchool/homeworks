package testpackage.sessions.tickets;


import testpackage.base.BaseClass;
import testpackage.cinema.Movie;
import testpackage.entity.Film;
import testpackage.factory.FilmFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sessions extends BaseClass {

    private List<Film> filmList = getDefaultFilmList();

    public List<Film> getDefaultFilmList() {
        return Stream.of(FilmFactory.buildListFilm(Movie.Films.JOKER),
                FilmFactory.buildListFilm(Movie.Films.SHOPLIFTERS),
                FilmFactory.buildListFilm(Movie.Films.ROCKETMAN),
                FilmFactory.buildListFilm(Movie.Films.SHAZAM),
                FilmFactory.buildListFilm(Movie.Films.US),
                FilmFactory.buildListFilm(Movie.Films.MIDWAY),
                FilmFactory.buildListFilm(Movie.Films.PARASITE),
                FilmFactory.buildListFilm(Movie.Films.LIGHTHOUSE),
                FilmFactory.buildListFilm(Movie.Films.ABOMINABLE),
                FilmFactory.buildListFilm(Movie.Films.HUSTLERS),
                FilmFactory.buildListFilm(Movie.Films.JUDY),
                FilmFactory.buildListFilm(Movie.Films.TERMINATOR),
                FilmFactory.buildListFilm(Movie.Films.MALEFICENT),
                FilmFactory.buildListFilm(Movie.Films.HARRIET),
                FilmFactory.buildListFilm(Movie.Films.COUNTDOWN)).collect(Collectors.toList());
    }

    public void uniqueGenresSortAlphabetically() {
        Map<String, String> map = filmList.stream().collect(
                Collectors.toMap(Film::getNameFilm, Film::getGenre));
        TreeMap<String, String> reversedTreeMap = new TreeMap<>();

        for (String i : map.keySet()) {
            reversedTreeMap.put(map.get(i), i);
        }
        for (Map.Entry<String, String> item : reversedTreeMap.entrySet()) {

            System.out.print(item.getKey() + " = " + item.getValue() + ", ");
        }
    }

    public void printFilmList() {
        for (Film film : filmList) {
            System.out.println(film);
        }
    }

    public Sessions sortFilmsByGenre(String genre) {
        filmList.removeIf(a -> (!a.getGenre().equals(genre)));
        return this;
    }

    public Sessions sortFilmsByAlphabetically() {
        Comparator<Film> comparator = Comparator.comparing(Film::getNameFilm);
        filmList.sort(comparator);
        return this;
    }

    public int isHas(String str) {
        int k = 0;
        for (Film film : filmList) {
            if (film.toString().contains(str)) {
                k++;
            }
        }
        return k;
    }

    public boolean haveAllMovieCriteria(String criteria) {
        if (isHas(criteria) == filmList.size()) {
            System.out.println("All movies in your list corresponds to your criteria");
            return true;
        } else {
            return false;
        }
    }

    public boolean hasOneMovieCriteria(String criteria) {
        if (isHas(criteria) > 0) {
            System.out.println("One movie in your list corresponds to your criteria");
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNoOneMovieCriteria(String criteria) {
        if (isHas(criteria) == 0) {
            System.out.println("Not one movie on your list matches your criteria");
            return true;
        } else {
            return false;
        }
    }
}
