package com.hotel.room;

import com.hotel.user.Customer;

import java.util.LinkedList;
import java.util.List;

public class SharedRoom extends Room implements IPlace {

    private int numberOfPlaces;
    private int numberOfBookingPlaces;
    private List<Customer> guests = new LinkedList();

    public SharedRoom(int number, int numbOfPlaces, double price, double size, boolean petFriendly) {
        super(number, price, size, petFriendly);
        this.numberOfPlaces = numberOfPlaces;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public List<Customer> getGuests() {
        return guests;
    }

    @Override
    public int getNumberOfFreePlaces() {
        return numberOfPlaces - numberOfBookingPlaces;
    }

    public void addNewBooking(Customer customer) {
        if (!isBooking()) {
            guests.add(customer);
            numberOfBookingPlaces++;
        }
        if (numberOfBookingPlaces == numberOfPlaces) setBooking(true);
    }

}
