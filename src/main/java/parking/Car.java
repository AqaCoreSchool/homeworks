package parking;

import java.util.Date;

public class Car extends AbstractVehicle {

    public Car() {
        setDefaultValues();
    }

    public Car(String owner, String number) {
        super(owner, number);
        setDefaultValues();
    }

    @Override
    public void setDefaultValues() {
        this.setVehicleType("Car");
        this.setPrice(10);
        this.setDateIn(new Date());
    }
}

