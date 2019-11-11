package com.company;

import java.util.Date;

public class Car extends Vehicle {

    public Car() {
        Standard();
    }

    public Car(String owner, String number) {
        super(owner, number);
        Standard();
    }

    @Override
    void Standard() {
        this.setType("Car");
        this.setPrice(10);
        this.setDateIn(new Date());
    }
}

