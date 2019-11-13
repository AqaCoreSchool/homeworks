package com.hotel;

import com.hotel.room.Room;
import com.hotel.room.SharedRoom;
import com.hotel.room.SingleRoom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelAccount {

    private static List<Room> allRooms = new ArrayList<Room>();
    private List<Room> allFreeRooms = new ArrayList<Room>();
    private List<Room> allFreeRoomsByCustomerSearch = new ArrayList<Room>();


    public void addNewRoom(Room room) {
        allRooms.add(room);
        //System.out.println(room.getClass().getSimpleName() + " №" + room.getNumber() + " успішно додана до списку кімнат");
    }

    //Повертає всі вільні кімнати
    public List<Room> getFreeRooms() {
        allFreeRooms.clear();
        for (Room room : allRooms) {
            if (!room.isBooking()) allFreeRooms.add(room);
        }
        return allFreeRooms;
    }

    //Повертає вільні кімнати в ціновому діапазоні
    public List<Room> getFreeRooms(double from, double to) {
        allFreeRooms.clear();
        for (Room room : allRooms)
            if (room.getPrice() >= from & room.getPrice() <= to & !room.isBooking())
                allFreeRooms.add(room);
        return allFreeRooms;
    }

    //Повертає всі вільні загальні кімнати
    public List<Room> getFreeSharedRooms() {
        allFreeRooms.clear();
        for (Room room : allRooms)
            if (room.getClass().getSimpleName().equals(SharedRoom.class.getSimpleName()) & !room.isBooking())
                allFreeRooms.add(room);
        return allFreeRooms;
    }

    //Повертає вільні загальні кімнати в ціновому діапазоні
    public List<Room> getFreeSharedRooms(double from, double to) {
        allFreeRooms.clear();
        allFreeRoomsByCustomerSearch.clear();
        for (Room room : getFreeSharedRooms())
            if (room.getPrice() >= from & room.getPrice() <= to)
                allFreeRoomsByCustomerSearch.add(room);
        return allFreeRoomsByCustomerSearch;
    }

    //Повертає всі вільні одиночні кімнати
    public List<Room> getFreeSingleRooms() {
        allFreeRooms.clear();
        for (Room room : allRooms)
            if (room.getClass().getSimpleName().equals(SingleRoom.class.getSimpleName()) & !room.isBooking())
                allFreeRooms.add(room);
        return allFreeRooms;
    }

    //Повертає вільні загальні кімнати в ціновому діапазоні
    public List<Room> getFreeSingleRooms(double from, double to) {
        allFreeRooms.clear();
        allFreeRoomsByCustomerSearch.clear();
        for (Room room : getFreeSingleRooms())
            if (room.getPrice() >= from & room.getPrice() <= to)
                allFreeRoomsByCustomerSearch.add(room);
        return allFreeRoomsByCustomerSearch;
    }
}
