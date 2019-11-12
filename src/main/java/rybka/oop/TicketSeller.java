package rybka.oop;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TicketSeller extends Employee {

    private static Set<Ticket> ticketSet = new HashSet<Ticket>();

    public static void sell(List<Customer> customers) {

        for (Customer customer : customers) {
            for (Map.Entry<Film, String> entry : Schedule.schedule.entrySet()) {
                if (entry.getKey().getTitle().equals(customer.getFilmTitle())
                        && entry.getValue().equals(customer.getFilmStart())
                        && entry.getKey().getCinema().getSeatsNumber() >= customer.getCustomerPlace()) {
                    sellTicket(customer, entry.getKey().getCinema());
                }
            }
        }
    }

    private static void sellTicket(Customer customer, Cinema cinema) {
        Ticket ticket = new Ticket(customer, cinema);
        ticketSet.add(ticket);
        System.out.println(ticket);
    }
}