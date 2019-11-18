package hotelRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomsSort {

    public List<TypesHotelRooms> rooms = new ArrayList<>();

    public RoomsSort() {

        rooms.add(new TypesHotelRooms("Single room", 100, 1, 1, 15, true));
        rooms.add(new TypesHotelRooms("Single room", 100, 1, 1, 15, false));
        rooms.add(new TypesHotelRooms("Single room", 150, 1, 1, 20, true));
        rooms.add(new TypesHotelRooms("Single room", 150, 1, 1, 20, true));

        rooms.add(new TypesHotelRooms("Double room", 200, 2, 1, 30, false));
        rooms.add(new TypesHotelRooms("Double room", 200, 2, 1, 30, true));
        rooms.add(new TypesHotelRooms("Double room", 250, 2, 1, 35, true));

        rooms.add(new TypesHotelRooms("Two rooms number", 400, 4, 2, 50, false));
        rooms.add(new TypesHotelRooms("Two rooms number", 400, 4, 2, 50, true));

        rooms.add(new TypesHotelRooms("Vip room", 800, 4, 2, 80, false));
        rooms.add(new TypesHotelRooms("Vip room", 800, 4, 3, 80, true));

    }

    public void getByCost() {
        Collections.sort(rooms, new CostComparator());
        for (TypesHotelRooms room : rooms) {
            System.out.println(room);
        }
    }

    public void getByCategory() {
        rooms.sort(new CategoryComparator());
        for (TypesHotelRooms element : rooms) {
            System.out.println(element);
        }
    }

    boolean hasCapacity(int capacity) {
        for (TypesHotelRooms next : rooms) {
            if (next.getCapacity() < capacity) {
                return true;
            }
        }
        return false;
    }

    void hasEmpty(boolean presence) {
        List<TypesHotelRooms> existence = new ArrayList<>();
        for (TypesHotelRooms next : rooms) {
            if (true) {
                existence.add(next);
                System.out.println(existence);
            }

        }

    }
}



/*System.out.println("Hotel rooms :" + room.getCategory() + "cost: " + room.getCost()
        + "capacity: " + room.getCapacity() + "number of rooms: " + room.getNumberOfRooms()
        + "area: " + room.getArea());*/

