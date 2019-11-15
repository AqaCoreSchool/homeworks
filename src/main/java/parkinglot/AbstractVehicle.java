package parkinglot;

public abstract class AbstractVehicle {

    private String licensePlate;

    AbstractVehicle(String licensePlate) {
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
