package parkinglot;

import parkinglot.Enums.SpotStatus;

public class ParkingSpot {

    private final int spotNumber;
    private String spotStatus;

    ParkingSpot(int spotNumber) {
        //System.out.println("Initialization of new parking spot: " + spotNumber);
        this.spotNumber = spotNumber;
        this.spotStatus = SpotStatus.FREE.toString();
    }

    public void parkVehicleOnParkingSpot(AbstractVehicle vehicle) {
        spotStatus = SpotStatus.BUSY.toString();
    }

    public void unparkVehicleFromParkingSpot(AbstractVehicle vehicle) {
        spotStatus = SpotStatus.FREE.toString();
    }

    public String getSpotStatus() {
        return spotStatus;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

}