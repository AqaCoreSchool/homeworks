package com.hotel;

import com.hotel.room.FamilyRoom;
import com.hotel.room.SharedRoom;
import com.hotel.room.SingleRoom;
import com.hotel.user.Customer;
import com.hotel.user.User;

public class MainClass {

    private static HotelAccount hotel = new HotelAccount();
    private static Customer customer = new Customer("Ivan", 25, "MWIvanko@gmail.com");

    public static void main(String[] args) {

        prepareHotelAccount();
        createSomeCustomerSearchRequest();


    }

    //Add HotelAccount for all Users
    private static HotelAccount prepareHotelAccount() {
        User.setHotelAccount(hotel);
        addSomeRooms();
        return hotel;
    }

    //Add different rooms in HotelAccount
    private static void addSomeRooms() {
        hotel.addNewRoom(new SingleRoom(1, 1500));
        hotel.addNewRoom(new SingleRoom(2, 1700));
        hotel.addNewRoom(new SingleRoom(3, 1800));
        hotel.addNewRoom(new SharedRoom(11, 8, 300));
        hotel.addNewRoom(new SharedRoom(12, 6, 500));
        hotel.addNewRoom(new SharedRoom(13, 5, 600));
        hotel.addNewRoom(new FamilyRoom(21, 2, 1, 2000));
        hotel.addNewRoom(new FamilyRoom(22, 4, 2, 2500));
        hotel.addNewRoom(new FamilyRoom(23, 5, 2, 2800));


    }

    //Create different search request for rooms search
    private static void createSomeCustomerSearchRequest() {
        //Показати користувачеві всі вільні кімнати
        customer.showChooseRooms(User.getHotelAccount().getFreeRooms());
        System.out.println("----------------------------------------");

        //Запит користувача на всі вільні загальні кімнати
        customer.showChooseRooms(User.getHotelAccount().getFreeSharedRooms());
        System.out.println("----------------------------------------");

        //Запит користувача на всі вільні одиночні кімнати
        customer.showChooseRooms(User.getHotelAccount().getFreeSingleRooms());
        System.out.println("----------------------------------------");

        //Запит користувачеві всі вільні кімнати в діапазоні ціни
        customer.showChooseRooms(User.getHotelAccount().getFreeRooms(300, 2700));
        System.out.println("----------------------------------------");

        //Запит користувачеві всі вільні загальні кімнати в діапазоні ціни
        customer.showChooseRooms(User.getHotelAccount().getFreeSharedRooms(300, 2700));
        System.out.println("----------------------------------------");

        //Запит користувачеві всі вільні одиночні кімнати в діапазоні ціни
        customer.showChooseRooms(User.getHotelAccount().getFreeSingleRooms(300, 2700));
        System.out.println("----------------------------------------");

        //Запит користувачеві всі вільні кімнати в діапазоні ціни (з негативним результатом)
        customer.showChooseRooms(User.getHotelAccount().getFreeRooms(100, 290));
        System.out.println("----------------------------------------");

    }
}
