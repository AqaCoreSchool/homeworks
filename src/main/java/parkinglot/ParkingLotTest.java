package parkinglot;

import parkinglot.Exceptions.ParkingLotIsEmptyException;
import parkinglot.Exceptions.ParkingLotIsFullException;
import parkinglot.Exceptions.ParkingTicketNumberNotFoundException;
import parkinglot.Exceptions.VehicleNotFoundOnParkingLotException;

import java.util.concurrent.TimeUnit;

public class ParkingLotTest {

    public static void main(String[] args) throws InterruptedException {

        ParkingLot parkingLot = new ParkingLot("Lviv1", "Rynok square, 1", 4);

        // uncomment for exception test
        //ParkingLot parkingLot = new ParkingLot("Lviv1", "Rynok square, 1", 4);

        // initialization of vehicles

        AbstractVehicle car1 = new Car("AA0001AA", "Max");
        AbstractVehicle car2 = new Car("BC0001AC", "Ivan");
        AbstractVehicle car3 = new Car("BX5678XX", "Petro");
        AbstractVehicle motorcycle1 = new Motorcycle("AC1112CC", "John");
        AbstractVehicle motorcycle2 = new Motorcycle("AC1155AA", "Kevin");
        AbstractVehicle bus1 = new Bus("BC0088XX", "Andy");
        AbstractVehicle bus2 = new Bus("BC2222OA", "Ivan");
        AbstractVehicle bus3 = new Bus("AA0088XX", "Ivan");
        AbstractVehicle bus4 = new Bus("BI5678HX", "Vasyl");

        int timeout = 2; // timeout for delay between parking/unparking of new vehicle

//        // park vehicle
//        try {
//            System.out.println(parkingLot.parkVehicleOnParkingLot(car1));
//        } catch (ParkingLotIsFullException e) {
//            System.out.println(e.getMessage());
//        }
//        TimeUnit.SECONDS.sleep(timeout);
//
//        // park vehicle
//        try {
//            System.out.println(parkingLot.parkVehicleOnParkingLot(car2));
//        } catch (ParkingLotIsFullException e) {
//            System.out.println(e.getMessage());
//        }
//        TimeUnit.SECONDS.sleep(timeout);

        String parkingTicketNumber = null;

        // unpark vehicle
        try {
            parkingTicketNumber = parkingLot.getParkingTicketNumber(car1);
            try {
                System.out.println(parkingLot.unparkVehicleFromParkingLot(car1, parkingTicketNumber));
            } catch (VehicleNotFoundOnParkingLotException | ParkingLotIsEmptyException e) {
                System.out.println(e.getMessage());
            }
        } catch (VehicleNotFoundOnParkingLotException | ParkingTicketNumberNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // unpark vehicle
        try {
            parkingTicketNumber = parkingLot.getParkingTicketNumber(car1);
            try {
                System.out.println(parkingLot.unparkVehicleFromParkingLot(car1, parkingTicketNumber));
            } catch (VehicleNotFoundOnParkingLotException | ParkingLotIsEmptyException e) {
                System.out.println(e.getMessage());
            }
        } catch (VehicleNotFoundOnParkingLotException | ParkingTicketNumberNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // park vehicle
        try {
            System.out.println(parkingLot.parkVehicleOnParkingLot(car3));
        } catch (ParkingLotIsFullException e) {
            System.out.println(e.getMessage());
        }
        TimeUnit.SECONDS.sleep(timeout);

        // park vehicle
        try {
            System.out.println(parkingLot.parkVehicleOnParkingLot(motorcycle1));
        } catch (ParkingLotIsFullException e) {
            System.out.println(e.getMessage());
        }
        TimeUnit.SECONDS.sleep(timeout);


        // park vehicle
        try {
            System.out.println(parkingLot.parkVehicleOnParkingLot(bus3));
        } catch (ParkingLotIsFullException e) {
            System.out.println(e.getMessage());
        }
        TimeUnit.SECONDS.sleep(timeout);


        // unpark vehicle
        try {
            parkingTicketNumber = parkingLot.getParkingTicketNumber(motorcycle1);
            try {
                System.out.println(parkingLot.unparkVehicleFromParkingLot(motorcycle1, parkingTicketNumber));
            } catch (VehicleNotFoundOnParkingLotException | ParkingLotIsEmptyException e) {
                System.out.println(e.getMessage());
            }
        } catch (VehicleNotFoundOnParkingLotException | ParkingTicketNumberNotFoundException e) {
            System.out.println(e.getMessage());
        }
        TimeUnit.SECONDS.sleep(timeout);

        // park vehicle
        try {

            System.out.println(parkingLot.parkVehicleOnParkingLot(motorcycle1));
        } catch (ParkingLotIsFullException e) {
            System.out.println(e.getMessage());
        }
        TimeUnit.SECONDS.sleep(timeout);

        try {
            parkingTicketNumber = "000100";
            try {
                System.out.println(parkingLot.unparkVehicleFromParkingLot(car1, parkingTicketNumber));
            } catch (VehicleNotFoundOnParkingLotException | ParkingLotIsEmptyException e) {
                System.out.println(e.getMessage());
            }
        } catch (VehicleNotFoundOnParkingLotException | ParkingTicketNumberNotFoundException e) {
            System.out.println(e.getMessage());
        }
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println("List of parked vehicles");
        System.out.println(parkingLot.getListOfVehicles());


        String type = "car";
        System.out.println("\nList of parked vehicles by type: " + type);
        System.out.println(parkingLot.getListOfVehicles(type));

        String searchCriteria;
        System.out.println("\nCheck parked vehicles by search criteria");

        searchCriteria = "t*car";
        System.out.println(searchCriteria + ": " + parkingLot.checkVehicle(searchCriteria)); // returns true if all <*> parked vehicles are of type <t> "car"

        searchCriteria = "t+car: ";
        System.out.println(searchCriteria + ": " + parkingLot.checkVehicle(searchCriteria)); // returns true if at least one <+> of parked vehicles are of type <t> "car"

        searchCriteria = "p!BC";
        System.out.println(searchCriteria + ": " + parkingLot.checkVehicle(searchCriteria)); // returns true if there are no <!> parked license plates <p> start from "BC"

        searchCriteria = "o+Ivan";
        System.out.println(searchCriteria + ": " + parkingLot.checkVehicle(searchCriteria)); // returns true if at least one <+> Ivan of parked vehicle owners <o>


        System.out.println("\nSorted list os unique license plates of parked vehicles");
        System.out.println(parkingLot.getSortedLicensePlates());

        System.out.println("\nVehicles list according to duration staying on a parking lot");
        System.out.println(parkingLot.sortAccordingToDuration());

    }
}