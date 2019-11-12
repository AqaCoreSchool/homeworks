package rybka.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cinema cinemaIMAX = new CinemaIMAX(30, 3, 80);
        Cinema cinema3D = new Cinema3D(40, 5, 50);
        Cinema cinema2D = new Cinema2D(60, 8, 60);

        Film film1 = new Film("Hellboy", cinemaIMAX);
        Film film2 = new Film("Terminator", cinema3D);
        Film film3 = new Film("It", cinema2D);

        Schedule.setSchedule(film1, "12:00");
        Schedule.setSchedule(film2, "14:00");
        Schedule.setSchedule(film3, "16:00");

        List<Customer> customers = new ArrayList<Customer>();

        Customer customer1 = new Customer("Andrii Rybka", "Hellboy", "12:00", 5);
        Customer customer2 = new Customer("Taras Gaydar", "Terminator", "14:00", 12);
        Customer customer3 = new Customer("Mickie Rurck", "It", "16:00", 30);
        Customer customer4 = new Customer("Oleh Vynnyk", "It", "16:00", 60);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        TicketSeller.sell(customers);

    }
}
