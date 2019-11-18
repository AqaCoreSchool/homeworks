package cinema;

import cinema.enumeration.CinemaCategory;
import cinema.enumeration.FilmCountry;
import cinema.enumeration.FilmGenre;
import cinema.enumeration.SeatStatus;
import com.createsend.models.campaigns.Campaign;
import com.github.javafaker.Faker;
import cinema.additional.Random;

import java.util.*;

public class Method {
    private List<SessionFilm> filmsList;
    private Map<Integer, String> map;

    Method() {
        filmsList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Faker faker = new Faker();
            String name = faker.company().name();
            FilmGenre genre = FilmGenre.randomFilmGenre();
            FilmCountry country = FilmCountry.randomFilmCountry();
            double year = Random.getRandomNumber(1998, 2019);
            CinemaCategory category = CinemaCategory.randomCinemaCategory();
            filmsList.add(new SessionFilm(name, genre, country, year, category));
        }
    }

    void getAllFilms() {
        for (SessionFilm film : filmsList) {
            System.out.println(film.getName() + " : " + film.getFilmGenre() + " : " + film.getCountry() +
                    " : " + film.getYear());
        }
    }

    List<SessionFilm> getFilmsByGenre(String genre) {
        List<SessionFilm> tempList = new ArrayList<>();
        for (SessionFilm film : filmsList) {
            if (SessionFilm.getFilmGenre().toString().contains(genre)) {
                tempList.add(film);
                System.out.println(film.getName() + " : " + film.getFilmGenre());
            }
        }
        return tempList;
    }

    boolean checkOneByYear(double year) {
        for (SessionFilm sessionFilm : filmsList) {
            if (sessionFilm.getYear() > year) {
                return true;
            }
        }
        return false;
    }

    boolean checkOneByTime(float time) {
        for (SessionFilm sessionFilm : filmsList) {
            if (sessionFilm.getDuration() < time) {
                return true;
            }
        }
        return false;
    }


    void getAlphabeticFilm(){
        filmsList.sort(Comparator.comparing(SessionFilm::getName));
//        Collections.sort(filmsList, new Comparator<Campaign>() {
//            @Override
//            public int compare(final Campaign object1, final Campaign object2) {
//                return object1.getClass().getName().compareTo(object2.getClass().getName());
//            }
//        });
    }



    List<SessionFilm> getFilmList() {
        return filmsList;
    }

    public Map<Integer, String> getMap() {
        return map;
    }


    Map putValuesInMap(List<SessionFilm> filmItem) {
        map = new HashMap<>();
        for (SessionFilm film : filmsList) {
            map.put((int) film.getYear(), film.getName());
        }
        return map;
    }



}
