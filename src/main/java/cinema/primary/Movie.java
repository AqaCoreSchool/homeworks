package cinema.primary;

import cinema.enums.Genre;

import java.util.List;

public class Movie implements Comparable<Movie>{
    private String filmName;
    private Genre filmGenre;
    private int yearRelease;
    private int duration;
    private int ageRating;
    private List<Session> sessions;

    public Movie(String filmName, Genre filmGenre, int yearRelease, int duration, int ageRating, List<Session> sessions) {
        this.filmName = filmName;
        this.filmGenre = filmGenre;
        this.yearRelease = yearRelease;
        this.duration = duration;
        this.ageRating = ageRating;
        this.sessions = sessions;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Genre getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(Genre filmGenre) {
        this.filmGenre = filmGenre;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "filmName='" + filmName + '\'' +
                ", filmGenre=" + filmGenre +
                ", yearRelease=" + yearRelease +
                ", duration=" + duration +
                ", ageRating=" + ageRating +
                ", sessions=" + sessions +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return this.getFilmName().compareTo(o.getFilmName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (yearRelease != movie.yearRelease) return false;
        if (duration != movie.duration) return false;
        if (ageRating != movie.ageRating) return false;
        if (filmName != null ? !filmName.equals(movie.filmName) : movie.filmName != null) return false;
        if (filmGenre != null ? !filmGenre.equals(movie.filmGenre) : movie.filmGenre != null) return false;
        return sessions != null ? sessions.equals(movie.sessions) : movie.sessions == null;
    }

    @Override
    public int hashCode() {
        int result = filmName != null ? filmName.hashCode() : 0;
        result = 31 * result + (filmGenre != null ? filmGenre.hashCode() : 0);
        result = 31 * result + yearRelease;
        result = 31 * result + duration;
        result = 31 * result + ageRating;
        result = 31 * result + (sessions != null ? sessions.hashCode() : 0);
        return result;
    }
}
