package testpackage.sessions.tickets;

import testpackage.base.BaseClass;
import testpackage.cinema.Movie;
import testpackage.entity.Film;
import testpackage.factory.FilmFactory;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class Sessions extends BaseClass {

    private List<Film> filmList = getDefaultFilmList();

    public List<Film> getDefaultFilmList() {
        return Stream.of(FilmFactory.buildListFilm(Movie.JOKER),
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
    }

    public void uniqueGenresSortAlphabetically() {
        Map<String, String> filmDescription = filmList.stream().collect(
                Collectors.toMap(Film::getNameFilm, Film::getGenre));
        TreeMap<String, String> reversedTreeMap = filmDescription.keySet().stream()
                .collect(Collectors.toMap(filmDescription::get, i -> i, (a, b) -> b, TreeMap::new));
        reversedTreeMap.forEach((key, value) -> System.out.print(key + " - " + value + ", "));
    }

    public void printFilmList(List<Film> list) {
        checkForEmptyList(list);
        list.forEach(System.out::println);
    }

    public void printFilmsByGenre(String genre) {
        checkForEmptyList(filmList);
        filmList.stream().filter(film -> film.getGenre().equalsIgnoreCase(genre))
                .forEach(movie -> System.out.println(movie.getNameFilm() + " - " + movie.getGenre()));
    }

    public void printFilmsByDate() {
        checkForEmptyList(filmList);
        Map<String, LocalDate> filmDescription = filmList.stream().collect(
                Collectors.toMap(Film::getNameFilm, Film::getDate));
        filmDescription.forEach((key, value) -> System.out.print(key + " - " + value + "\n "));
    }

    public void printFilmsByAlphabetically() {
        checkForEmptyList(filmList);
        filmList.stream().map(Film::getNameFilm).sorted().forEach(System.out::println);
    }

    public boolean haveAllMovieCriteria(String criteria) {
        return filmList.stream().allMatch(film -> film.toString().contains(criteria));
    }

    public boolean hasOneMovieCriteria(String criteria){
            return filmList.stream().anyMatch(film -> film.toString().contains(criteria));
        }

    public boolean hasNoMovieCriteria(String criteria) {
        return filmList.stream().noneMatch(film -> film.toString().contains(criteria));
    }
  
    private void checkForEmptyList(List<Film> list){
        if(null == list || list.isEmpty()){
            throw new IllegalStateException("Film list is empty");
        }
    }