package com.hotel;

import com.hotel.room.FamilyRoom;
import com.hotel.room.Room;
import com.hotel.room.SharedRoom;
import com.hotel.room.SingleRoom;
import com.hotel.user.Customer;
import com.hotel.user.User;

import java.sql.SQLOutput;
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

        List<Room> rooms = User.getHotelAccount().getFreeRooms();
        //Показати користувачеві всі вільні кімнати
        user.showChooseRooms(User.getHotelAccount().getFreeRooms());
        System.out.println("----------------------------------------");

        //Запит користувача на всі вільні загальні кімнати
        user.showChooseRooms(User.getHotelAccount().getFreeSharedRooms());
        System.out.println("----------------------------------------");

        //Запит користувача на всі вільні одиночні кімнати
        user.showChooseRooms(User.getHotelAccount().getFreeSingleRooms());
        System.out.println("----------------------------------------");

        //Запит користувачеві всі вільні кімнати в діапазоні ціни
        user.showChooseRooms(User.getHotelAccount().getFreeRooms(300, 2700));
        System.out.println("----------------------------------------");

        //Запит користувачеві всі вільні загальні кімнати в діапазоні ціни
        user.showChooseRooms(User.getHotelAccount().getFreeSharedRooms(300, 2700));
        System.out.println("----------------------------------------");

        //Запит користувачеві всі вільні одиночні кімнати в діапазоні ціни
        user.showChooseRooms(User.getHotelAccount().getFreeSingleRooms(300, 2700));
        System.out.println("----------------------------------------");

        //Запит користувачеві всі вільні кімнати в діапазоні ціни (з негативним результатом)
        user.showChooseRooms(User.getHotelAccount().getFreeRooms(100, 290));
        System.out.println("----------------------------------------");
        //Показати користувачеві всі вільні кімнати в порядку від дешевших до дорожчих
        user.showChooseRooms(User.getHotelAccount().getFreeSortedRoomsUp());
        System.out.println("----------------------------------------");


        //Показати користувачеві всі вільні кімнати в порядку від дорожчих до дешевших
        user.showChooseRooms(User.getHotelAccount().getFreeSortedRoomsDown());
        System.out.println("----------------------------------------");

        //Показати користувачеві результат перевірки "Чи хоча б одна кімната відповідає параметру пошуку"

        user.showCheckingResult(User.getHotelAccount().hasRoomAppropriateToCriterion(rooms, 400));

        //Показати користувачеві результат перевірки "Чи всі кімната відповідають параметру пошуку"
        user.showCheckingResult(User.getHotelAccount().isAllRoomsAppropriateToCriterion(rooms, 40));

        rooms = User.getHotelAccount().getFreeSingleRooms();

        //Показати користувачеві результат перевірки "Чи всі кімната відповідають певному критерію"
        user.showCheckingResult(User.getHotelAccount().isAllRoomsPerFriendly(rooms));

        //Показати користувачеві список всіх кімнат відсортованих по ціні (від дорожчих до дешевших)
        showSeparatedRoomName(User.getHotelAccount().getFreeSortedRoomsDown());
    }

    //Show room type with number sorted for price
    private static void showSeparatedRoomName(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.print(room.getClass().getSimpleName() + " №" + room.getNumber() + " / ");
        }
    }
}
