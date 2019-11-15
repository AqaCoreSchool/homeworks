package rybka.oop2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Application {

    private List<Movie> movies;

    Application() {
        movies = new ArrayList<>();
        movies.add(new Movie("10:00, 14:00, 21:00", "Doctor Sleep", FilmCategory.HORROR.getCategoryName(), 2.5, 2019));
        movies.add(new Movie("9:00, 11:00, 14:00", "Terminator: Dark Fate", FilmCategory.ACTION.getCategoryName(), 2.1, 2019));
        movies.add(new Movie("13:00, 17:00, 20:00", "The matrix", FilmCategory.ACTION.getCategoryName(), 2.3, 1999));
        movies.add(new Movie("15:00, 18:00, 21:00", "Fight Club", FilmCategory.DRAMA.getCategoryName(), 2.3, 1999));
        movies.add(new Movie("11:00, 13:00, 16:00", "Rampage", FilmCategory.ACTION.getCategoryName(), 1.8, 2018));
        movies.add(new Movie("10:00, 12:00, 14:00", "The Predator", FilmCategory.ACTION.getCategoryName(), 1.8, 2018));
        movies.add(new Movie("13:00, 17:00, 22:00", "The Perfect Ones", FilmCategory.ACTION.getCategoryName(), 1.6, 2018));
        movies.add(new Movie("11:00, 15:00, 19:00", "Deadpool", FilmCategory.ACTION.getCategoryName(), 1.7, 2016));
        movies.add(new Movie("9:00, 12:00, 14:00", "Zootopia", FilmCategory.COMEDY.getCategoryName(), 1.8, 2016));
        movies.add(new Movie("10:00, 13:00, 15:00", "The Martian", FilmCategory.FANTASY.getCategoryName(), 2.4, 2015));
        movies.add(new Movie("10:00, 14:00, 16:00", "Chappie", FilmCategory.THRILLER.getCategoryName(), 2.0, 2015));
        movies.add(new Movie("9:30, 11:30, 15:30", "127 Hours", FilmCategory.THRILLER.getCategoryName(), 1.5, 2010));
        movies.add(new Movie("10:30, 12:30, 16:30", "The King's Speech", FilmCategory.DRAMA.getCategoryName(), 1.9, 2010));
        movies.add(new Movie("13:30, 14:45, 15:45", "Despicable Me", FilmCategory.COMEDY.getCategoryName(), 1.6, 2010));
        movies.add(new Movie("13:43, 15:23, 17:53", "Mega Piranha", FilmCategory.HORROR.getCategoryName(), 1.5, 2010));
    }

    void showSessionList() {
        for (Movie movie : movies) {
            System.out.println(movie.getSessions() + "\t" + movie.getTitle());
        }
    }

    void filterByGenre(String genre) {
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(movie.getSessions() + "\t" + movie.getTitle());
            }
        }
    }

    void sortMovies() {
        Collections.sort(movies, new Comparator<Movie>() {
            public int compare(Movie movie1, Movie movie2) {
                return movie1.getTitle().compareTo(movie2.getTitle());
            }
        });

        for (Movie movie : movies) {
            System.out.println(movie.getSessions() + "\t" + movie.getTitle());
        }
    }

    boolean isAtLeastOneMovie(double duration) {
        byte counter = 0;
        for (Movie movie : movies) {
            if (movie.getDuration() > duration) {
                counter++;
            }
        }
        return counter <= 1;
    }

    boolean isAllMovies(int year) {
        int counter = 0;
        for (Movie movie : movies) {
            if (movie.getYear() >= year) {
                counter++;
            }
        }
        return counter == movies.size();
    }

    boolean isNoneMovies(String title) {
        int counter = 0;
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title) || movie.getTitle().contains(title)) {
                counter++;
            }
        }
        return counter == 0;
    }

    void collectUniqueGenres() {
        List<String> genres = new ArrayList<>();

        for (Movie movie : movies) {
            if (!genres.contains(movie.getGenre())) {
                genres.add(movie.getGenre());
            }
        }

        Collections.sort(genres);
        System.out.println(String.join(", ", genres));
    }
}

