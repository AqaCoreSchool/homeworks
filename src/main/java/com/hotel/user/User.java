package com.hotel.user;

import com.hotel.HotelAccount;
import com.hotel.room.Room;

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

    public abstract Room chooseRoom();
}
