package parking;

import java.util.Date;

public class Truck extends AbstractVehicle {

    public Truck() {
        standard();
    }

    Truck(String owner, String number) {
        super(owner, number);
        standard();
    }

    @Override
    void standard() {
        this.setVehicleType("Truck");
        this.setPrice(20);
        this.setDateIn(new Date());
    }
}
