package rybka.cinema;

public abstract class Cinema {
    private int seatsNumber;
    private int filmsNumber;
    private int ticketPrice;

    public Cinema(int seatsNumber, int filmsNumber, int ticketPrice) {
        this.seatsNumber = seatsNumber;
        this.filmsNumber = filmsNumber;
        this.ticketPrice = ticketPrice;
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

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
