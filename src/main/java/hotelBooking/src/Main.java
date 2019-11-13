import HotelRooms.DoubleRoom;
import HotelRooms.SingleRoom;
import HotelRooms.SortRoom;
import HotelRooms.VipRoom;
import Сustomers.Adult;
import Сustomers.Child;
import Сustomers.Pensioner;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.ToIntFunction;

public class Main {

    public static <T> void main(String[] args) {

        Adult adult;
        Child child;
        Pensioner pensioner;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age :");

        int value = scanner.nextInt();

        adult = new Adult(value, 100);
        child = new Child(value, 50);
        pensioner = new Pensioner(value, 70);

        if ((value >= 14)) {
            adult.getHuman();
        }else if(value <= 60) {
            child.getHuman();
        }else {
            pensioner.getHuman();
        }

        List <SortRoom> rooms = new ArrayList<>();

        SortRoom singleRoom = new SortRoom(100, 1);
        SortRoom doubleRoom = new SortRoom(200, 2);
        SortRoom vipRoom = new SortRoom(400, 4);

        rooms.add(singleRoom);
        rooms.add(doubleRoom);
        rooms.add(vipRoom);



       /* Payment payment = new Payment();
        payment.cashToPay();
        payment.cashlessToPay();*/


    }
}