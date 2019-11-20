package com.hotel.user;

import com.hotel.BookingOrder;
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
    public void chooseRoom(List<Room> rooms) {
       //for example
    }

    public boolean checkBookingRequest(Customer customer) {
        //Verification logic must be added, and after that
        return bookingRoom(customer.getOrder());
    }

    private boolean bookingRoom(BookingOrder order) {
       order.getRoom().setBooking(true);
       order.getRoom().setBookingDataFrom(order.getBookingDateFrom());
       order.getRoom().setBookingDays(order.getBookingDays());
       return order.getRoom().isBooking();
    }

}
