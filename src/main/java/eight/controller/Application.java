package eight.controller;

import com.github.javafaker.Faker;
import eight.exception.NoSuchGenreException;
import eight.exception.NoSuchTitleException;
import eight.exception.NotAYearException;
import eight.exception.UnsupportedDurationException;
import eight.model.FilmCategory;
import eight.model.Movie;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

public class Application {

    private List<Movie> movies;

    public Application() {
        movies = new ArrayList<>();
        Faker faker = new Faker(new Locale("en-US"));
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            movies.add(new Movie(LocalTime.of(random.nextInt(24), random.nextInt(59)),
                    faker.name().title(), FilmCategory.getRandomCategory(), (1.0 + (3.0 - 1.0) * random.nextDouble()),
                    random.nextInt(2020 - 1990) + 1990));
        }
    }

    public void showSessionList() {
        // movies.forEach(movie -> System.out.println(movie.getSession() + "\t" + movie.getTitle() + "\t" +
        //        movie.getGenre() + "\t" + movie.getDuration() + "\t" + movie.getYear()));
        String result = movies
                .stream()
                .map(movie -> String.join("\t", movie.getSession().toString(), movie.getTitle(), movie.getGenre(),
                        Double.toString(movie.getDuration()), Integer.toString(movie.getYear())))
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    public void filterByGenre(String genre) throws NoSuchGenreException {
        if (genre.matches("\\d*")) {
            throw new NoSuchGenreException("Not a genre format");
        }

        movies.stream().filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .forEach(movie -> System.out.println(movie.getSession() + "\t" + movie.getTitle()));
    }

    public void sortMovies() {
        movies.stream().map(Movie::getTitle).sorted().forEach(System.out::println);
    }

    public boolean hasDurationMoreThen(double duration) throws UnsupportedDurationException {
        if (duration <= 0) {
            throw new UnsupportedDurationException("Wrong duration format found!");
        }

        return movies.stream().anyMatch(movie -> movie.getDuration() > duration);
    }

    public boolean hasYearMoreThan(int year) throws NotAYearException {
        if (year <= 0 || !String.valueOf(year).matches("\\d{4}")) {
            throw new NotAYearException("Wrong year format found!");
        }

        return movies.stream().allMatch(movie -> movie.getYear() >= year);
    }

    public boolean hasTitleLike(String title) throws NoSuchTitleException {
        if (title.matches("^\\d*$|^\\W")) {
            throw new NoSuchTitleException("Wrong title input!");
        }

        return movies.stream().noneMatch(movie -> movie.getTitle().equalsIgnoreCase(title)
                || movie.getTitle().contains(title));
    }

    public void collectUniqueGenres() {
        System.out.println(movies.stream().map(Movie::getGenre).distinct().sorted()
                .collect(Collectors.joining(", ")));
    }
}

