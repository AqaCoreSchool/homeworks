package hotelRooms;

import java.util.Date;

public class Reservation {

    private Date inDate;
    private Date outDate;

    public Reservation(Date inDate, Date outDate) {
        this.inDate = inDate;
        this.outDate = outDate;
    }
}
