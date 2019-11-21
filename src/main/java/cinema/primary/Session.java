package cinema.primary;


import java.time.LocalDate;
import java.time.LocalTime;

public class Session {
    private Hall hall;
    private double price;
    private LocalTime startSession;
    private LocalDate startDate;

    public Session(Hall hall, double price, LocalTime startSession, LocalDate startDate) {
        this.hall = hall;
        this.price = price;
        this.startSession = startSession;
        this.startDate = startDate;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalTime getStartSession() {
        return startSession;
    }

    public void setStartSession(LocalTime startSession) {
        this.startSession = startSession;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Session{" +
                "hall=" + hall +
                ", price=" + price +
                ", startSession=" + startSession +
                ", startDate=" + startDate +
                '}';
    }
}
