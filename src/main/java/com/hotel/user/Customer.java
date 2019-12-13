package com.hotel.user;

import com.hotel.order.BookingOrder;
import com.hotel.room.Room;

import java.time.LocalDate;
import java.util.List;

public class Customer extends User {

    private int age;
    private String email;
    private BookingOrder order;

    public BookingOrder getOrder() {
        return order;
    }

    public void setOrder(Room room, LocalDate bookingDateFrom, int bookingDays, int numberOfMembers) {
        this.order = new BookingOrder(room, bookingDateFrom, bookingDays, numberOfMembers);
    }

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

    @Override
    public void chooseRoom(List<Room> rooms) {
        //Some code where Customer choose room from
        //For example
        Room myRoom = null;
        List<Room> freeRooms = null;

        freeRooms = getHotelAccount().getFreeRooms();

        for (Room room : freeRooms) {
            if (room.getPrice() < 1000) myRoom = room;
        }
        createBookingRequest(myRoom);
    }

    public void createBookingRequest(Room myRoom) {
        System.out.println("Your booking request has been sent to the administrator");
        setOrder(myRoom, LocalDate.of(2019, 12, 5), 7, 2);
    }

    public void cancelBooking() {
        order.getRoom().setBooking(false);
    }
}
