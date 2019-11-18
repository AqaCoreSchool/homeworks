package parkinglot;

public abstract class AbstractVehicle {

    private String licensePlate;
    private String ownerName;

    AbstractVehicle(String licensePlate, String ownerName) {
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