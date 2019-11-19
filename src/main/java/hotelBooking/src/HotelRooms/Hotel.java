package hotelRooms;

import java.util.HashMap;

public class Hotel {

    public HashMap<Integer, Reservation> reservedDates;

    public HashMap<Integer, Reservation> getEmptyRooms() {
          return reservedDates;
    }
}
