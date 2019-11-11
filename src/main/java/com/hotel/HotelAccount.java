package com.hotel;

import com.hotel.room.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelAccount {

    private List<Room> allRooms = new ArrayList<Room>();

    public List<Room> getAllFreeRooms(){
        List<Room> allFreeRooms = new ArrayList<Room>();
        for (Room room:allRooms) {
            if(!room.isBooking())allFreeRooms.add(room);
        }
        return getAllFreeRooms();
    }
}
