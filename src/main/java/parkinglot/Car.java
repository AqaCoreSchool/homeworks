package parkinglot;

public class Car extends Vehicle {

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
