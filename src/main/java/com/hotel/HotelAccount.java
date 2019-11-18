package com.hotel;

import com.hotel.room.Room;
import com.hotel.room.SharedRoom;
import com.hotel.room.SingleRoom;

import java.util.*;

public class HotelAccount {

    private static List<Room> allRooms = new ArrayList<Room>();
    private List<Room> allFreeRooms = new ArrayList<Room>();
    private List<Room> allFreeRoomsByCustomerSearch = new ArrayList<Room>();


    public void addNewRoom(Room room) {
        allRooms.add(room);
    }

    //Повертає всі вільні кімнати
    public List<Room> getFreeRooms() {
        allFreeRooms.clear();
        for (Room room : allRooms) {
            if (!room.isBooking()) {
                allFreeRooms.add(room);
            }
        }
        return allFreeRooms;
    }

    //Повертає вільні кімнати в ціновому діапазоні
    public List<Room> getFreeRooms(double from, double to) {
        allFreeRooms.clear();
        for (Room room : allRooms) {
            if (room.getPrice() >= from & room.getPrice() <= to & !room.isBooking()) {
                allFreeRooms.add(room);
            }
        }
        return allFreeRooms;
    }

    //Повертає всі вільні загальні кімнати
    public List<Room> getFreeSharedRooms() {
        allFreeRooms.clear();
        for (Room room : allRooms) {
            if (SharedRoom.class.isInstance(room) & !room.isBooking()) {
                allFreeRooms.add(room);
            }
        }

        return allFreeRooms;
    }

    //Повертає вільні загальні кімнати в ціновому діапазоні
    public List<Room> getFreeSharedRooms(double from, double to) {
        allFreeRooms.clear();
        allFreeRoomsByCustomerSearch.clear();

        for (Room room : getFreeSharedRooms()) {
            if (room.getPrice() >= from & room.getPrice() <= to) {
                allFreeRoomsByCustomerSearch.add(room);
            }
        }
        return allFreeRoomsByCustomerSearch;
    }

    //Повертає всі вільні одиночні кімнати
    public List<Room> getFreeSingleRooms() {
        allFreeRooms.clear();
        for (Room room : allRooms) {
            if (SingleRoom.class.isInstance(room) & !room.isBooking()) {
                allFreeRooms.add(room);
            }
        }
        return allFreeRooms;
    }

    //Повертає вільні загальні кімнати в ціновому діапазоні
    public List<Room> getFreeSingleRooms(double from, double to) {
        allFreeRooms.clear();
        allFreeRoomsByCustomerSearch.clear();
        for (Room room : getFreeSingleRooms()) {
            if (room.getPrice() >= from & room.getPrice() <= to) {
                allFreeRoomsByCustomerSearch.add(room);
            }
        }
        return allFreeRoomsByCustomerSearch;
    }

    //Повертаємо всі вільні кімнати відсортовані по ціні вверх
    public List<Room> getFreeSortedRoomsUp() {
        allFreeRoomsByCustomerSearch.clear();
        allFreeRoomsByCustomerSearch.addAll(getFreeRooms());
        Collections.sort(allFreeRoomsByCustomerSearch, new Comparator<Room>() {
            @Override
            public int compare(Room room1, Room room2) {
                return (int) (room1.getPrice() - room2.getPrice());
            }
        });
        return allFreeRoomsByCustomerSearch;
    }

    //Повертаємо всі вільні кімнати відсортовані по ціні вниз
    public List<Room> getFreeSortedRoomsDown() {
        allFreeRoomsByCustomerSearch.clear();
        allFreeRoomsByCustomerSearch.addAll(getFreeRooms());
        Collections.sort(allFreeRoomsByCustomerSearch, new Comparator<Room>() {
            @Override
            public int compare(Room room1, Room room2) {
                return (int) (room2.getPrice() - room1.getPrice());
            }
        });
        return allFreeRoomsByCustomerSearch;
    }

    //Перевіряє чи в списку кімнат є хоча б одна, що відповідає критерію
    public boolean hasRoomAppropriateToCriterion(List<Room> rooms, double price) {
        for (Room room : rooms) {
            if (room.getPrice() < price) {
                return true;
            }
        }
        return false;
    }

    //Перевіряємо чи в списку кімнат всі відповідають критерію
    public boolean isAllRoomsAppropriateToCriterion(List<Room> rooms, double size) {
        for (Room room : rooms) {
            if (room.getSize() > size) {
                return false;
            }
        }
        return true;
    }

    //Перевіряємо чи в списку кімнат всі відповідають критерію
    public boolean isAllRoomsPerFriendly(List<Room> rooms) {
        for (Room room : rooms) {
            if (!room.isPetFriendly()) {
                return false;
            }
        }
        return true;
    }
}
