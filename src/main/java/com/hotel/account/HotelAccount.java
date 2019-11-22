package com.hotel.account;

import com.hotel.exceptions.RoomNotFoundException;
import com.hotel.room.Room;
import com.hotel.room.SharedRoom;
import com.hotel.room.SingleRoom;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelAccount {

    private static List<Room> allRooms = new ArrayList<>();

    public static List<Room> getAllRooms() {
        return allRooms;
    }

    public void addNewRoom(Room room) {
        allRooms.add(room);
    }

    //Returns all free rooms
    public List<Room> getFreeRooms() {
        return getAllRoomsByCondition(room -> !room.isBooking());
    }

    //Returns all free rooms in price range
    public List<Room> getFreeRooms(double from, double to) {
        return getAllRoomsByCondition((room) -> room.getPrice() >= from && room.getPrice() <= to);
    }

    //Returns all free shared rooms
    public List<Room> getFreeSharedRooms() {
        return getAllRoomsByCondition(room -> room instanceof SharedRoom && !room.isBooking());
    }

    //Returns all free shared rooms in price range
    public List<Room> getFreeSharedRooms(double from, double to) {
        return getAllRoomsByCondition(room -> SharedRoom.class.isInstance(room) &&
                !room.isBooking() && room.getPrice() >= from && room.getPrice() <= to);
    }

    //Returns all free single rooms
    public List<Room> getFreeSingleRooms() {
        return getAllRoomsByCondition(room -> room instanceof SingleRoom && !room.isBooking());
    }

    //Returns all free single rooms in price range
    public List<Room> getFreeSingleRooms(double from, double to) {
        return getAllRoomsByCondition(room -> SingleRoom.class.isInstance(room) &&
                !room.isBooking() && room.getPrice() >= from && room.getPrice() <= to);
    }

    //Returns all free rooms sorted by increase prise
    public List<Room> getFreeSortedRoomsByPriceUp() {
        return getFreeSortedRooms((room1, room2) -> (int) (room1.getPrice() - room2.getPrice()));
    }

    //Returns all free rooms sorted by decrease prise
    public List<Room> getFreeSortedRoomsByPriceDown() {
        return getFreeSortedRooms((room1, room2) -> (int) (room2.getPrice() - room1.getPrice()));
    }

    //Selects room by condition
    public List<Room> getAllRoomsByCondition(Predicate<Room> condition) {
        List<Room> allFreeRooms = allRooms.stream().
                filter(condition).collect(Collectors.toList());
        if (allFreeRooms.isEmpty()) {
            throw new RoomNotFoundException("No rooms found for your search");
        }
        return allFreeRooms;
    }

    //Sorts room by criterion
    public List<Room> getFreeSortedRooms(Comparator<Room> roomComparator) {

        List<Room> sortedRooms = getFreeRooms().stream().sorted(roomComparator).collect(Collectors.toList());
        if (sortedRooms.isEmpty()) {
            throw new RoomNotFoundException("No rooms found for your search");
        }
        return sortedRooms;
    }

    //Check if at least one property in room list corresponds to criteria
    public boolean hasRoomAppropriateToCriterion(List<Room> rooms, double price) {
        return rooms.stream().anyMatch(room -> room.getPrice() > price);
    }

    //Check if all room in room list corresponds to criteria
    public boolean areAllRoomsAppropriateToCriterion(List<Room> rooms, double size) {
        return rooms.stream().allMatch(room -> room.getSize() > size);
    }

    //Check if at none of the rooms in room list corresponds to criteria
    public boolean areAllRoomsPerFriendly(List<Room> rooms) {
        return rooms.stream().noneMatch(room -> room.isPetFriendly());
    }
}
