package testpackage.sessions.tickets;

import testpackage.base.BaseClass;
import testpackage.cinema.Movie;
import testpackage.entity.Film;
import testpackage.factory.FilmFactory;

import java.util.*;

public class Sessions extends BaseClass {

    private List<Film> filmList = getDefaultFilmList();

    public List<Film> getDefaultFilmList() {
        List<Film> list = new ArrayList<>();
        list.addAll(Arrays.asList(FilmFactory.buildListFilm(Movie.JOKER),
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
                FilmFactory.buildListFilm(Movie.COUNTDOWN)));
        return list;
    }

    public void uniqueGenresSortAlphabetically() {
        Map<String, String> filmDescription = new HashMap<>();
        for (Film film : filmList) {
            if (filmDescription.put(film.getNameFilm(), film.getGenre()) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        TreeMap<String, String> reversedTreeMap = new TreeMap<>();

        for (String i : filmDescription.keySet()) {
            reversedTreeMap.put(filmDescription.get(i), i);
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

    private int numberOfFilmsForIntendedCriterion(String str) {
        int k = 0;
        for (Film film : filmList) {
            if (film.toString().contains(str)) {
                k++;
            }
        }
        return k;
    }

    public boolean haveAllMovieCriteria(String criteria) {
        if (numberOfFilmsForIntendedCriterion(criteria) == filmList.size()) {
            System.out.println("All movies in your list corresponds to your criteria");
            return true;
        } else {
            return false;
        }
    }

    public boolean hasOneMovieCriteria(String criteria) {
        if (numberOfFilmsForIntendedCriterion(criteria) > 0) {
            System.out.println("One movie in your list corresponds to your criteria");
            return true;
        } else {
            return false;
        }
    }

    public boolean hasNoOneMovieCriteria(String criteria) {
        if (numberOfFilmsForIntendedCriterion(criteria) == 0) {
            System.out.println("Not one movie on your list matches your criteria");
            return true;
        } else {
            return false;
        }
    }
}
