package parkinglot;

import parkinglot.Enums.VehicleType;

public class Bus extends AbstractVehicle {

    private final String type = VehicleType.BUS.toString();
    private final int size = VehicleType.BUS.getSize();

    Bus(String licensePlate, String ownerName) {
        super(licensePlate, ownerName);
    }

    public String getVehicleType() {
        return type;
    }

    public int getVehicleSize() {
        return size;
    }
}