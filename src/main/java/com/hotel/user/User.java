package com.hotel.user;

import com.hotel.account.HotelAccount;
import com.hotel.room.Room;

import java.util.List;

public abstract class User {

    private String name;
    private static HotelAccount hotelAccount;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static HotelAccount getHotelAccount() {
        return hotelAccount;
    }

    public static void setHotelAccount(HotelAccount hotelAccount) {
        User.hotelAccount = hotelAccount;
    }

    public abstract void chooseRoom(List<Room> rooms);

    public void showChooseRooms(List<Room> chooseRooms) {

        System.out.printf("%-40s %-15s %n", "", "Our rooms for you");
        System.out.printf("%-12s %-12s %-12s %-12s %-15s %-12s %-20s  %-20s %n",
                "Room type", "Room number", "Room size", "Price", "Other",
                "Booking", "Booking Date From", "Booking Date To");
        System.out.println("------------------------------------------------------------------------" +
                "------------------------------------------------");
        for (Room room : chooseRooms) {
            String isPetFriendly = "";
            String isBooking = "";
            String bookingDateFrom = "";
            String bookingDateTo = "";

            if (room.isPetFriendly()) {
                isPetFriendly = "Pet friendly";
            }
            if (room.isBooking()) {
                isBooking = "Booked";
                bookingDateFrom = room.getBookingDateFrom().toString();
                bookingDateTo = room.getBookingDateTo().toString();
            } else {
                isBooking = "Free";
            }

            System.out.printf("%-16s %-10s %-10s %-9s %-19s %-14s %-19s  %-20s %n",
                    room.getClass().getSimpleName(), room.getNumber(), room.getSize(),
                    room.getPrice(), isPetFriendly, isBooking, bookingDateFrom, bookingDateTo);
        }
        System.out.println("------------------------------------------------------------------------" +
                "------------------------------------------------");
        System.out.println();

    }

    public void showCheckingResult(boolean isSuccessful) {
        if (isSuccessful) {
            System.out.println("Checking successful");
        } else {
            System.out.println("Checking unsuccessful");
        }
    }
}
