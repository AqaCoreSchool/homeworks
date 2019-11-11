package rybka.oop;

import java.util.List;
import java.util.Map;

public class TicketSeller extends Employee {

    public static void sell(List<Customer> customers) {

        for (Customer customer : customers) {
            for (Map.Entry<String, Film> entry : Schedule.schedule.entrySet()) {
                if (entry.getKey().equals(customer.getFilmStart()) && entry.getValue().getTitle().equals(customer.getFilmTitle())) {
                    System.out.println(new Ticket(customer));
                }
            }
        }
    }
}