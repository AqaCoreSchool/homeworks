import customers.PriceCategory;
import hotelRooms.Hotel;
import hotelRooms.Reservation;
import hotelRooms.RoomsSort;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PriceCategory priceCategory = new PriceCategory();
        priceCategory.selectionPriceCategory();

        RoomsSort category = new RoomsSort();
        category.getByCategory();
        category.getByCost();

        try (Scanner sc = new Scanner(System.in)) {
            int value = sc.nextInt();
        }catch (NumberFormatException e){
            System.out.println("Wrong dial format !");
        }

        Hotel hotel = new Hotel();
        HashMap<Integer, Reservation> reservedDates = hotel.getEmptyRooms();

        Payment payment = new Payment();
        payment.cashToPay();
        payment.cashlessToPay();


    }
}