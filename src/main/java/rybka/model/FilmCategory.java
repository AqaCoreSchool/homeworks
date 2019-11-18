package rybka.model;

public enum FilmCategory {
    ACTION,
    COMEDY,
    DRAMA,
    HORROR,
    THRILLER,
    FANTASY;

    public String getCategoryName() {
        return this.name();
    }
}
