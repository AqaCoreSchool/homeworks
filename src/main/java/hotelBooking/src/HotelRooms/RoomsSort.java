package hotelRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomsSort {

    TypesHotelRooms singleRoom = new TypesHotelRooms("Single room",100, 1, 1, 15);
    TypesHotelRooms doubleRoom = new TypesHotelRooms("Double room", 200, 2, 1, 30);
    TypesHotelRooms twoRoomsNumber = new TypesHotelRooms("Two rooms number", 400, 4, 2, 50);
    TypesHotelRooms vipRoom = new TypesHotelRooms("Vip room", 800, 4, 2, 80);

    public RoomsSort() {
        List<TypesHotelRooms> rooms = new ArrayList<>();
        rooms.add(singleRoom);
        rooms.add(doubleRoom);
        rooms.add(twoRoomsNumber);
        rooms.add(vipRoom);

        Collections.sort(rooms, new RoomsComparator());

        for (TypesHotelRooms room: rooms){
            System.out.println("Hotel rooms :" + room.getCategory() + "cost: " + room.getCost()
                    + "capacity: " + room.getCapacity() + "number of rooms: " + room.getNumberOfRooms()
                    + "area: " + room.getArea());
        }


    }
}
