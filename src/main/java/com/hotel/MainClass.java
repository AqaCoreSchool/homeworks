package com.hotel;

import com.hotel.account.HotelAccount;
import com.hotel.room.FamilyRoom;
import com.hotel.room.Room;
import com.hotel.room.SharedRoom;
import com.hotel.room.SingleRoom;
import com.hotel.user.Customer;
import com.hotel.user.User;

import java.util.List;

public class MainClass {

    private static HotelAccount hotel = new HotelAccount();
    private static User user = new Customer("Ivan", 25, "Ivanko@gmail.com");

    public static void main(String[] args) {
        prepareHotelAccount();
        createCustomerSearchRequest();
    }

    //Add HotelAccount for all Users
    private static HotelAccount prepareHotelAccount() {
        User.setHotelAccount(hotel);
        addRooms();
        return hotel;
    }

    //Add different rooms in HotelAccount
    private static void addRooms() {
        hotel.addNewRoom(new SingleRoom(1, 2100, 20, true));
        hotel.addNewRoom(new SingleRoom(2, 1700, 23, false));
        hotel.addNewRoom(new SingleRoom(3, 1800, 27, false));
        hotel.addNewRoom(new SharedRoom(11, 8, 300, 42, false));
        hotel.addNewRoom(new SharedRoom(12, 6, 500, 40, false));
        hotel.addNewRoom(new SharedRoom(13, 5, 700, 37, true));
        hotel.addNewRoom(new FamilyRoom(21, 2000, 34, 2, 1, false));
        hotel.addNewRoom(new FamilyRoom(22, 2500, 60, 3, 2, true));
        hotel.addNewRoom(new FamilyRoom(23, 2800, 75, 5, 3, false));
    }

    //Create different search request for rooms search
    private static void createCustomerSearchRequest() {

        List<Room> rooms = null;

        rooms = User.getHotelAccount().getFreeRooms();

        user.showChooseRooms(HotelAccount.getAllRooms());

        user.showChooseRooms(User.getHotelAccount().getFreeRooms());

        user.showChooseRooms(User.getHotelAccount().getFreeSharedRooms());

        user.showChooseRooms(User.getHotelAccount().getFreeSingleRooms());

        user.showChooseRooms(User.getHotelAccount().getFreeRooms(300, 2700));

        user.showChooseRooms(User.getHotelAccount().getFreeSharedRooms(300, 2700));

        user.showChooseRooms(User.getHotelAccount().getFreeSingleRooms(300, 2700));

        user.showChooseRooms(User.getHotelAccount().getFreeRooms(100, 400));

        user.showChooseRooms(User.getHotelAccount().getFreeSortedRoomsByPriceUp());

        user.showChooseRooms(User.getHotelAccount().getFreeSortedRoomsByPriceDown());

        user.showCheckingResult(User.getHotelAccount().hasRoomAppropriateToCriterion(rooms, 400));

        user.showCheckingResult(User.getHotelAccount().areAllRoomsAppropriateToCriterion(rooms, 40));

        rooms = User.getHotelAccount().getFreeSingleRooms();

        user.showCheckingResult(User.getHotelAccount().areAllRoomsPerFriendly(rooms));
    }
}
