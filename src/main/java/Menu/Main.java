package Menu;

import hotel.Hotel;
import human.Emploee;
import human.Human;
import recep.Reception;
import room.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;

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
