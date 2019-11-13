package ParkingLot;

import java.util.Date;

public class Car extends Vehicle {

    public Car() {
        standard();
    }

    public Car(String owner, String number) {
        super(owner, number);
        standard();
    }

    @Override
    void standard() {
        this.setType("Car");
        this.setPrice(10);
        this.setDateIn(new Date());
    }
}

