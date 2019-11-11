package rybka.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CinemaIMAX cinemaIMAX = new CinemaIMAX(30, 3);
        Cinema3D cinema3D = new Cinema3D(40, 5);
        Cinema2D cinema2D = new Cinema2D(60, 8);

        Film film1 = new Film("Hellboy", cinemaIMAX);
        Film film2 = new Film("Terminator", cinema3D);
        Film film3 = new Film("It", cinema2D);

        Schedule.setSchedule("12:00", film1);
        Schedule.setSchedule("14:00", film2);
        Schedule.setSchedule("16:00", film3);

        List<Customer> customers = new ArrayList<Customer>();

        Customer customer1 = new Customer("Andrii Rybka", cinemaIMAX, "Hellboy", "12:00", 5);
        Customer customer2 = new Customer("Taras Gaydar", cinema3D, "Terminator", "14:00", 12);
        Customer customer3 = new Customer("Mickie Rurck", cinema2D, "It", "17:00", 30);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        TicketSeller.sell(customers);

    }
}
