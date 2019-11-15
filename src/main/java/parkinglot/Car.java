package parkinglot;

import parkinglot.Enums.VehicleType;

public class Car extends AbstractVehicle {

    private final String type = VehicleType.CAR.toString();
    private final int size = VehicleType.CAR.getSize();

    Car (String licensePlate, String ownerName) {
        super(licensePlate, ownerName);

    }

    public String getVehicleType() {
        return type;
    }

    public int getVehicleSize() {
        return size;
    }
}