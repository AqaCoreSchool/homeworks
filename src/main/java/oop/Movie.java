package oop;



import java.util.List;

public class Movie extends Cinema{
    private String filmName;
    private String filmGenre;
    private int yearRelease;
    private int duration;
    private int ageRating;
    private List<Session> sessions;


    public Movie(String filmName, String filmGenre, int yearRelease, int duration, int ageRating, List<Session> sessions) {
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

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
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
                ", filmGenre='" + filmGenre + '\'' +
                ", yearRelease=" + yearRelease +
                ", duration=" + duration +
                ", ageRating=" + ageRating +
                ", sessions=" + sessions +
                '}';
    }


}
