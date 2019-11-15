package hotelRooms;

import java.util.Comparator;

public class RoomsComparator implements Comparator<TypesHotelRooms> {

    public int compare(TypesHotelRooms o1, TypesHotelRooms o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }else if (o1 == null) {
            return -1;
        }else if (o2 == null) {
            return 1;
        }

        int value = o1.getCost() - o2.getCost();
        if (value != 0) {
            return value;
        }

        return value;
    }
}