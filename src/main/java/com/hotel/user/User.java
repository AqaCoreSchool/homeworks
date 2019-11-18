package com.hotel.user;

import com.hotel.HotelAccount;
import com.hotel.room.Room;
import com.sun.deploy.util.StringUtils;

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

    public abstract Room chooseRoom(List<Room> rooms);

    public void showChooseRooms(List<Room> chooseRooms) {

        System.out.printf("%-25s %-15s %n", "", "Free rooms for you");
        System.out.printf("%-12s %-12s %-12s %-12s %-9s %n",
                "Room type", "Room number", "Room size", "Price", "Other");
        System.out.println("--------------------------------------------------------------");
        for (Room room : chooseRooms) {
            String s = "";
            if (room.isPetFriendly()) {
                s = "Pet friendly";
            }
            System.out.printf("%-12s %-12s %-12s %-12s %-9s %n",
                    room.getClass().getSimpleName(), room.getNumber(), room.getSize(), room.getPrice(), s);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println();

    }

    public void showCheckingResult(boolean result) {
        if (result) {
            System.out.println("Checking successful");
        } else {
            System.out.println("Checking unsuccessful");
        }
    }
}
