package rybka.oop;

public class Ticket {
    Customer customer;
    String filmTitle;
    String time;
    int ticketCount;
    int price;

    public Ticket(Customer customer) {
        this.customer = customer;
        this.filmTitle = customer.getFilmTitle();
        this.time = customer.getFilmStart();
        this.ticketCount = customer.getTicketsNumber();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "customer=" + customer.getName() + '\'' +
                "filmTitle='" + filmTitle + '\'' +
                ", time='" + time + '\'' +
                ", ticketCount=" + ticketCount +
                ", price=" + price +
                '}';
    }
}
