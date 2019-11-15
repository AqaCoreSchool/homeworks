package parkinglot;

public class ParkingLotTest {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(5);

        Vehicle vehicle = new Car("AA0001AA");
        Vehicle vehicle2 = new Car("BC0001AC");

        System.out.println(parkingLot.addVehicleToParkingLot(vehicle));
        System.out.println(parkingLot.addVehicleToParkingLot(vehicle2));

        String parkingTicketNumber = parkingLot.getParkingTicketNumber(vehicle);

        //System.out.println(parkingTicketNumber);

        System.out.println(parkingLot.removeVehicleFromParkingLot(vehicle, parkingTicketNumber));

        Vehicle vehicle3 = new Car("BX5678XX");
        System.out.println(parkingLot.addVehicleToParkingLot(vehicle3));
    }
}
