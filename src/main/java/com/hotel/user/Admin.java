package com.hotel.user;

import com.hotel.room.Room;

import java.util.List;

public class Admin extends User {

    private int id;
    private String password;

    public Admin(String name, String password) {
        super(name);
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Room chooseRoom(List<Room> rooms) {
        return null;
    }

    public void checkBookingRequest(Customer customer) {
        if (customer.getAge() > 20 & !customer.getRoom().isBooking()) bookingRoom(customer.getRoom(), customer);
    }



    private void bookingRoom(Room room, Customer customer) {
        room.setBooking(true);
        //Set customer for room, after create room type check
    }
}
