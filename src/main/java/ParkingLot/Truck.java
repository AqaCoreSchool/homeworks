package com.company;

import java.util.Date;

public class Truck extends Vehicle {

    public Truck() {
        Standard();
    }

    public Truck(String owner, String number) {
        super(owner, number);
        Standard();
    }

    @Override
    void Standard() {
        this.setType("Truck");
        this.setPrice(20);
        this.setDateIn(new Date());
    }
}
