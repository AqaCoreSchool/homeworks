package parkinglot;

import java.util.concurrent.TimeUnit;

public class ParkingLotTest {

    public static void main(String[] args) throws InterruptedException {

        ParkingLot parkingLot = new ParkingLot("Lviv1","Rynok square, 1", 10);

        // initialization of vehicles

        Vehicle car1 = new Car("AA0001AA", "Max");
        Vehicle car2 = new Car("BC0001AC", "Ivan");
        Vehicle car3 = new Car("BX5678XX", "Petro");
        Vehicle motorcycle1 = new Motorcycle("AC1112CC", "John");
        Vehicle motorcycle2 = new Motorcycle("AC1155AA", "Kevin");
        Vehicle bus1 = new Bus("BC0088XX", "Andy");
        Vehicle bus2 = new Bus("BC2222OA", "Ivan");
        Vehicle bus3 = new Bus("AA0088XX", "Ivan");
        Vehicle bus4 = new Bus("BI5678HX", "Vasyl");

        int timeout = 2; // timeout for delay between parking/unparking of new vehicle

        System.out.println(parkingLot.parkVehicleOnParkingLot(car1));
        TimeUnit.SECONDS.sleep(timeout);
        System.out.println(parkingLot.parkVehicleOnParkingLot(car2));
        TimeUnit.SECONDS.sleep(timeout);

        // unpark vehicle
        String parkingTicketNumber = parkingLot.getParkingTicketNumber(car1);
        System.out.println(parkingLot.unparkVehicleFromParkingLot(car1, parkingTicketNumber));


        System.out.println(parkingLot.parkVehicleOnParkingLot(car3));
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(parkingLot.parkVehicleOnParkingLot(motorcycle1));
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(parkingLot.parkVehicleOnParkingLot(bus3));
        TimeUnit.SECONDS.sleep(timeout);
        // unpark vehicle
        parkingTicketNumber = parkingLot.getParkingTicketNumber(motorcycle1);
        System.out.println(parkingLot.unparkVehicleFromParkingLot(motorcycle1, parkingTicketNumber));
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(parkingLot.parkVehicleOnParkingLot(motorcycle1));
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println("List of parked vehicles");
        System.out.println(parkingLot.getListOfVehicles());

        System.out.println("\n");

        String type = "car";
        System.out.println("List of parked vehicles by type: " + type);
        System.out.println(parkingLot.getListOfVehicles(type));

        System.out.println("\n");

        String searchCriteria;
        System.out.println("Check parked vehicles by search criteria");

        searchCriteria = "t*car";
        System.out.println(searchCriteria + ": " + parkingLot.checkVehicle(searchCriteria)); // returns true if all <*> parked vehicles are of type <t> "car"

        searchCriteria = "t+car: ";
        System.out.println(searchCriteria + ": " + parkingLot.checkVehicle(searchCriteria)); // returns true if at least one <+> of parked vehicles are of type <t> "car"

        searchCriteria = "p!BC";
        System.out.println(searchCriteria + ": " + parkingLot.checkVehicle(searchCriteria)); // returns true if there are no <!> parked license plates <p> start from "BC"

        searchCriteria = "o+Ivan";
        System.out.println(searchCriteria + ": " + parkingLot.checkVehicle(searchCriteria)); // returns true if at least one <+> Ivan of parked vehicle owners <o>

        System.out.println("\n");

        System.out.println("Print sorted unique license plates of parked vehicles");
        parkingLot.printSortedLicensePlates();

        System.out.println("\n");

        System.out.println("Print vehicles list according to duration staying on a parking lot");
        System.out.println(parkingLot.sortAccordingToDuration());

    }
}
