package parkinglot;

import parkinglot.Enums.VehicleType;

public class Motorcycle extends AbstractVehicle{

    private final String type = VehicleType.MOTORCYCLE.toString();
    private final int size = VehicleType.MOTORCYCLE.getSize();

    Motorcycle(String licensePlate, String ownerName) {
        super(licensePlate, ownerName);
    }

    public String getVehicleType() {
        return type;
    }

    public int getVehicleSize() {
        return size;
    }

}