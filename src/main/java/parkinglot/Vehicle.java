package parkinglot;

public abstract class Vehicle {

    private String licensePlate;
    private String ownerName;

    Vehicle(String licensePlate, String ownerName) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
    }

    public String getLicensePlates() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract String getVehicleType();

    public abstract int getVehicleSize();
}
