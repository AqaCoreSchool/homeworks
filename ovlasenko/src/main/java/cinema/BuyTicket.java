package cinema;

public class BuyTicket {
    private String date;
    private String ticketId;

    public BuyTicket(String date, String ticketId) {
        this.date = date;
        this.ticketId = ticketId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String creationDate) {
        this.date = date;
    }

    public String getTicketIdId() {
        return ticketId;
    }

    public void setTicketId(String memberId) {
        this.ticketId = ticketId;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "date='" + date + '\'' +
                ", ticketId='" + ticketId +
                '}';
    }
}
