package parkinglot;

public class Car extends AbstractVehicle {

    private String type;

    Car (String licensePlate) {
        super(licensePlate);
        this.type = VehicleType.CAR.toString();
    }

    public String getVehicleType() {
        return type;
    }

    public void setVehicleType() {
        this.type = "";
    };
}
