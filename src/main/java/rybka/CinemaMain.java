package rybka;

import rybka.cinema.Cinema;
import rybka.cinema.Cinema2D;
import rybka.cinema.Cinema3D;
import rybka.cinema.CinemaIMAX;
import rybka.entity.object.Film;
import rybka.entity.object.Schedule;
import rybka.entity.subject.Customer;
import rybka.entity.subject.TicketSeller;

import java.util.ArrayList;
import java.util.List;

public class CinemaMain {
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

        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer("Andrii Rybka", "Hellboy", "12:00", 5);
        Customer customer2 = new Customer("Taras Gaydar", "Terminator", "14:00", 12);
        Customer customer3 = new Customer("Mickie Rurck", "It", "16:00", 30);
        Customer customer4 = new Customer("Oleh Vynnyk", "Hellboy", "12:00", 12);
        Customer customer5 = new Customer("Carl Johnson", "It", "16:00", 4);
        Customer customer6 = new Customer("Mary Key", "Hellboy", "12:00", 6);
        Customer customer7 = new Customer("Ann Smith", "Terminator", "14:00", 76);
        Customer customer8 = new Customer("Henry Scott", "It", "16:00", 23);
        Customer customer9 = new Customer("Steve Jobs", "Hellboy", "12:00", 34);
        Customer customer10 = new Customer("Olga Popovich", "It", "16:00", 24);
        Customer customer11 = new Customer("Nasar Popol", "Terminator", "14:00", 25);
        Customer customer12 = new Customer("Bill Gates", "Hellboy", "12:00", 72);
        Customer customer13 = new Customer("Rick Monte", "It", "16:00", 42);
        Customer customer14 = new Customer("Bruce Waine", "Terminator", "14:00", 33);
        Customer customer15 = new Customer("Mickie Mouse", "Hellboy", "12:00", 1);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);
        customers.add(customer7);
        customers.add(customer8);
        customers.add(customer9);
        customers.add(customer10);
        customers.add(customer11);
        customers.add(customer12);
        customers.add(customer13);
        customers.add(customer14);
        customers.add(customer15);

        TicketSeller.sell(customers);

    }
}
