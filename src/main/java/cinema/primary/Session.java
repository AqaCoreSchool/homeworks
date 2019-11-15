package cinema.primary;


public class Session {
    private Hall hall;
    private double price;
    private double startSession;

    public Session(Hall hall, double price, double startSession) {
        this.hall = hall;
        this.price = price;
        this.startSession = startSession;
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

    public double getStartSession() {
        return startSession;
    }

    public void setStartSession(double startSession) {
        this.startSession = startSession;
    }

    @Override
    public String toString() {
        return "Session{" +
                "hall=" + hall +
                ", price=" + price +
                ", startSession=" + startSession +
                '}';
    }
}
