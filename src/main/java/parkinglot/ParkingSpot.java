package parkinglot;

public class ParkingSpot {
    private int spotNumber;
    private String spotStatus;

    private Vehicle vehicle;

    ParkingSpot(int spotNumber) {
        //System.out.println("Initialization of new parking spot: " + spotNumber);
        this.spotNumber = spotNumber;
        this.spotStatus = SpotStatus.FREE.toString();
    }

    public void addVehicle (Vehicle vehicle) {
        spotStatus = SpotStatus.BUSY.toString();
    }

    public void removeVehicle(Vehicle vehicle) {
        spotStatus = SpotStatus.FREE.toString();
    }
    public String getSpotStatus() {
        return spotStatus;
    }

    public String getVehicleLicensePlates() {
        return vehicle.getLicensePlate();
    }

    public String getVehicleType() {
        return vehicle.getVehicleType();
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}





