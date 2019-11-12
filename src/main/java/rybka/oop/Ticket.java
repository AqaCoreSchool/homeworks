package rybka.oop;

public class Ticket {
    private Customer customer;
    private Cinema cinemaType;
    private String filmTitle;
    private String time;
    private int ticketPlace;
    private int price;

    public Ticket(Customer customer, Cinema cinema) {
        this.customer = customer;
        this.filmTitle = customer.getFilmTitle();
        this.cinemaType = cinema;
        this.time = customer.getFilmStart();
        this.ticketPlace = customer.getCustomerPlace();
        this.price = cinema.getTicketPrice();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTicketPlace() {
        return ticketPlace;
    }

    public void setTicketPlace(int ticketPlace) {
        this.ticketPlace = ticketPlace;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Cinema getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(Cinema cinemaType) {
        this.cinemaType = cinemaType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "customer=" + customer.getName() + '\'' +
                ", filmTitle='" + filmTitle + '\'' +
                ", cinemaType='" + cinemaType.getClass().getSimpleName() + '\'' +
                ", time='" + time + '\'' +
                ", ticketPlace=" + ticketPlace +
                ", price=" + price +
                '}';
    }
}
