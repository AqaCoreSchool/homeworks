package rybka.oop;

public abstract class Cinema {
    private int seatsNumber;
    private int filmsNumber;

    public Cinema(int seatsNumber, int filmsNumber) {
        this.seatsNumber = seatsNumber;
        this.filmsNumber = filmsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getFilmsNumber() {
        return filmsNumber;
    }

    public void setFilmsNumber(int filmsNumber) {
        this.filmsNumber = filmsNumber;
    }
}
