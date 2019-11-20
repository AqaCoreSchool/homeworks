package parkinglot;

import parkinglot.Enums.VehicleType;

public class Van extends AbstractVehicle {

    private final String type = VehicleType.VAN.toString();
    private final int size = VehicleType.VAN.getSize();

    Van(String licensePlate, String ownerName) {
        super(licensePlate, ownerName);
    }

    public String getVehicleType() {
        return type;
    }

    public int getVehicleSize() {
        return size;
    }

}