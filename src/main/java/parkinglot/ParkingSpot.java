package parkinglot;

import parkinglot.Enums.SpotStatus;

public class ParkingSpot {

    private final int spotNumber;
    private String spotStatus;

    // add subSpot1 and subSpot2

    ParkingSpot(int spotNumber) {
        //System.out.println("Initialization of new parking spot: " + spotNumber);
        this.spotNumber = spotNumber;
        this.spotStatus = SpotStatus.FREE.toString();
    }

    public void parkVehicleOnParkingSpot(Vehicle vehicle) {
        spotStatus = SpotStatus.BUSY.toString();
    }

    public void unparkVehicleFromParkingSpot(Vehicle vehicle) {
        spotStatus = SpotStatus.FREE.toString();
    }

    public String getSpotStatus() {
        return spotStatus;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    // add subSpots methods
}





