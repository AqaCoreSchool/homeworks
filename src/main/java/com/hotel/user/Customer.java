package com.hotel.user;

import com.hotel.room.Room;

import java.util.List;

public class Customer extends User {

    private int age;
    private String email;
    private Room room;

    public Customer(String name, int age, String email) {
        super(name);
        this.age=age;
        this.email=email;
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
    public Room chooseRoom() {
        //Some code where Customer choose room
        //For example
        Room myRoom = null;
        List<Room> freeRooms = getHotelAccount().getAllFreeRooms();
        for (Room room : freeRooms) {
            if (room.getPrice() < 1000) myRoom = room;
        }

        return myRoom;
    }

    public void createBookingRequest(Room myRoom) {
        if (myRoom != null) {
            setRoom(myRoom);
            //Запит адміну на підтвердження бронювання
        } else System.out.println("Потрібної кімнати не знайдено");
    }

    public void cancelBooking() {
        if(getRoom()!=null)getRoom().setBooking(false);
    }
}
