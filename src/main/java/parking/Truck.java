package parking;

import java.util.Date;

public class Truck extends AbstractVehicle {

    public Truck() {
        setDefaultValues();
    }

    public Truck(String owner, String number) {
        super(owner, number);
        setDefaultValues();
    }

    @Override
    public void setDefaultValues() {
        this.setVehicleType("Truck");
        this.setPrice(20);
        this.setDateIn(new Date());
    }
}
