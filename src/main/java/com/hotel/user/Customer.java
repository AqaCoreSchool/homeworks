package com.hotel.user;

import com.hotel.exceptions.RoomNotFoundException;
import com.hotel.room.Room;

import java.util.List;

public class Customer extends User {

    private int age;
    private String email;
    private Room room;

    public Customer(String name, int age, String email) {
        super(name);
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


    @Override
    public Room chooseRoom(List<Room> rooms) {
        //Some code where Customer choose room from
        //For example
        Room myRoom = null;
        List<Room> freeRooms = null;

        freeRooms = getHotelAccount().getFreeRooms();

        for (Room room : freeRooms) {
            if (room.getPrice() < 1000) myRoom = room;
        }
        return myRoom;
    }

    public void createBookingRequest(Room myRoom) {
        setRoom(myRoom);
        //Запит адміну на підтвердження бронювання
        System.out.println("Your booking request has been sent to the administrator");
    }

    public void cancelBooking() {
        if (getRoom() != null) getRoom().setBooking(false);

    }
}
