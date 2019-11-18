package hotelRooms;

import java.util.Comparator;

public class CostComparator implements Comparator<TypesHotelRooms> {

    public int compare(TypesHotelRooms o1, TypesHotelRooms o2) {

        int value = o1.getCost() - o2.getCost();
        if (value != 0) {
            return value;
        }
        return value;
    }
}