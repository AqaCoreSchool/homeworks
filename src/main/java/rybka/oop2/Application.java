package rybka.oop2;

import java.util.*;

class Application {

    private List<Movie> movies;

    Application() {
        movies = new ArrayList<>();
        movies.add(new Movie("10:00, 14:00, 21:00", "Doctor Sleep", "Horror", 2.5, 2019));
        movies.add(new Movie("9:00, 11:00, 14:00", "Terminator: Dark Fate", "Action", 2.1, 2019));
        movies.add(new Movie("13:00, 17:00, 20:00", "The matrix", "Action", 2.3, 1999));
        movies.add(new Movie("15:00, 18:00, 21:00", "Fight Club", "Drama", 2.3, 1999));
        movies.add(new Movie("11:00, 13:00, 16:00", "Rampage", "Action", 1.8, 2018));
        movies.add(new Movie("10:00, 12:00, 14:00", "The Predator", "Action", 1.8, 2018));
        movies.add(new Movie("13:00, 17:00, 22:00", "The Perfect Ones", "Action", 1.6, 2018));
        movies.add(new Movie("11:00, 15:00, 19:00", "Deadpool", "Action", 1.7, 2016));
        movies.add(new Movie("9:00, 12:00, 14:00", "Zootopia", "Comedy", 1.8, 2016));
        movies.add(new Movie("10:00, 13:00, 15:00", "The Martian", "Fantasy", 2.4, 2015));
        movies.add(new Movie("10:00, 14:00, 16:00", "Chappie", "Thriller", 2.0, 2015));
        movies.add(new Movie("9:30, 11:30, 15:30", "127 Hours", "Thriller", 1.5, 2010));
        movies.add(new Movie("10:30, 12:30, 16:30", "The King's Speech", "Drama", 1.9, 2010));
        movies.add(new Movie("13:30, 14:45, 15:45", "Despicable Me", "Comedy", 1.6, 2010));
        movies.add(new Movie("13:43, 15:23, 17:53", "Mega Piranha", "Horror", 1.5, 2010));
    }

    void showSessionList() {
        for (Movie movie : movies) {
            System.out.println(movie.getSessions() + "\t" + movie.getTitle());
        }
    }

    void filterByGenre(String genre) {
        for (Movie movie : movies) {
            if (movie.getGenre().equals(genre)) {
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

    void checkIfAtLeastOneMovie(double duration) {
        for (Movie movie : movies) {
            if (movie.getDuration() > duration) {
                System.out.println(movie.getTitle() + "\t" + movie.getDuration());
            }
        }
    }

    void checkIfAllMovies(int year) {
        for (Movie movie : movies) {
            if (movie.getYear() >= year) {
                System.out.println(movie.getTitle() + "\t" + movie.getYear());
            }
        }
    }

    void checkIfNoneMovies(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title) || movie.getTitle().contains(title)) {
                System.out.println(movie.getSessions() + "\t" + movie.getTitle());
            }
        }
    }

    void collectUniqueGenres() {
        Set<String> genres = new TreeSet<>();

        for (Movie movie : movies) {
            genres.add(movie.getGenre());
        }

        System.out.println(String.join(", ", genres));
    }
}

class Movie {
    private String sessions;
    private String title;
    private String genre;
    private double duration;
    private int year;

    Movie(String sessions, String title, String genre, double duration, int year) {
        this.sessions = sessions;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.year = year;
    }

    String getSessions() {
        return sessions;
    }

    String getTitle() {
        return title;
    }

    String getGenre() {
        return genre;
    }

    double getDuration() {
        return duration;
    }

    int getYear() {
        return year;
    }
}