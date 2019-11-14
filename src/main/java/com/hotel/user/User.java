package com.hotel.user;

import com.hotel.HotelAccount;
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

    public abstract Room chooseRoom(List<Room> rooms);

    public void showChooseRooms(List<Room> chooseRooms) {
        if (chooseRooms.isEmpty()) System.out.println("Your search did not match any rooms");
        else for (Room room : chooseRooms) System.out.println(room.toString());

    }

    public void showCheckingResult(boolean result) {
        if (result) {
            System.out.println("Checking successful");
        } else {
            System.out.println("Checking unsuccessful");
        }
    }
}
