package hotelRooms;

import java.util.Comparator;

public class CategoryComparator implements Comparator<TypesHotelRooms> {

    public int compare(TypesHotelRooms o1, TypesHotelRooms o2) {
        int value = (o1.getCategory()).compareTo(o2.getCategory());
        return value;
    }

}
