package hotelRooms;

import java.util.HashMap;
import java.util.Map;

public class Hotel {

    private final int roomNumber;

    private Map<Integer, Reservation> reservedDates;

    public Hotel(int roomNumber){
        reservedDates = new HashMap<Integer, Reservation>();
        this.roomNumber = roomNumber;
    }
}
