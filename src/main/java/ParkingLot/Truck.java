package ParkingLot;

import java.util.Date;

public class Truck extends Vehicle {

    public Truck() {
        standard();
    }

    public Truck(String owner, String number) {
        super(owner, number);
        standard();
    }

    @Override
    void standard() {
        this.setType("Truck");
        this.setPrice(20);
        this.setDateIn(new Date());
    }
}
