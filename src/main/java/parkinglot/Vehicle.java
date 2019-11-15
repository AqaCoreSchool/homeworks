package parkinglot;

public abstract class Vehicle {

    private String licensePlate;

    Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate() {
        this.licensePlate = "";
    }

    public abstract String getVehicleType();

    public abstract void setVehicleType();

}
