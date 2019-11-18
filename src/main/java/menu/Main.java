package menu;

import hotel.Hotel;

public class Main {
    public static void main(String [] args) {
        Hotel hotel = new Hotel("FeridLand");
        System.out.println(hotel.showAllRooms());
        System.out.println(hotel.showSortedRooms());
        hotel.isCorrespond();
        hotel.isCorrespondAll();
        System.out.println(hotel.showUniqueRooms());
    }
}
