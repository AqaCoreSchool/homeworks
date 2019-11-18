package ParkingLot;

import java.util.Date;

public class Truck extends AbstractVehicle {

    public Truck() {
        standard();
    }

    public Truck(String owner, String number) {
        super(owner, number);
        standard();
    }

    @Override
    public void standard() {
        this.setVehicleType("Truck");
        this.setPrice(20);
        this.setDateIn(new Date());
    }
}
