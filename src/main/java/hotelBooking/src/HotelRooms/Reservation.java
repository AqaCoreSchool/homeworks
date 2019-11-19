package hotelRooms;

import java.util.Date;

public class Reservation {

    private Date inDate;
    private Date outDate;

    public Reservation(Date inDate, Date outDate) {
        this.inDate = inDate;
        this.outDate = outDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }
}
