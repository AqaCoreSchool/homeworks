package rybka.oop;

public class Customer {
    private String name;
    private Cinema cinemaType;
    private String filmTitle;
    private String filmStart;
    private int ticketsNumber;

    Customer(String name, Cinema cinemaType, String filmTitle, String filmStart, int ticketsNumber) {
        this.name = name;
        this.cinemaType = cinemaType;
        this.filmTitle = filmTitle;
        this.filmStart = filmStart;
        this.ticketsNumber = ticketsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cinema getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(Cinema cinemaType) {
        this.cinemaType = cinemaType;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmStart() {
        return filmStart;
    }

    public void setFilmStart(String filmStart) {
        this.filmStart = filmStart;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(int ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }
}
