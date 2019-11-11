package com.hotel.room;

import com.hotel.user.Customer;

public class SingleRoom extends Room {

    private Customer customer;

    public SingleRoom(int number, double price) {
        super(number, price);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
