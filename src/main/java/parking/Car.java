package parking;

import java.util.Date;

public class Car extends AbstractVehicle {

    public Car() {
        standard();
    }

    public Car(String owner, String number) {
        super(owner, number);
        standard();
    }

    @Override
    void standard() {
        this.setVehicleType("Car");
        this.setPrice(10);
        this.setDateIn(new Date());
    }
}

