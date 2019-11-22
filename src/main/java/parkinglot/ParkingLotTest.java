package parkinglot;

import java.util.concurrent.TimeUnit;

public class ParkingLotTest {

    public static void main(String[] args) throws InterruptedException {

        ParkingLot parkingLot = new ParkingLot("Lviv1", "Rynok square, 1", 10);

        // uncomment for exception test
        //ParkingLot parkingLot = new ParkingLot("Lviv1", "Rynok square, 1", 2);

        // initialization of vehicles

        AbstractVehicle car1 = new Car("AA0001AA", "Max");
        AbstractVehicle car2 = new Car("AA0001AC", "Ivan");
        AbstractVehicle car3 = new Car("AA5678XX", "Petro");
        AbstractVehicle motorcycle1 = new Motorcycle("AC1112CC", "John");
        AbstractVehicle motorcycle2 = new Motorcycle("AC1155AA", "Kevin");
        AbstractVehicle bus1 = new Van("BC0088XX", "Andy");
        AbstractVehicle bus2 = new Van("BC2222OA", "Ivan");
        AbstractVehicle bus3 = new Van("BC0088AX", "Ivan");

        int timeout = 1; // timeout for delay between parking/unparking of new vehicle
        String parkingTicketNumber = null;

        String stringFiller = "-----------------------------------------------------------------";

        // unpark vehicle car1
        parkingTicketNumber = parkingLot.getParkingTicketNumber(car1);
        parkingLot.unparkVehicleFromParkingLot(car1, parkingTicketNumber);

        System.out.println(stringFiller);

        // park vehicle car1
        parkingLot.parkVehicleOnParkingLot(car1);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // park vehicle car2
        parkingLot.parkVehicleOnParkingLot(car2);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // unpark vehicle car1
        parkingTicketNumber = parkingLot.getParkingTicketNumber(car1);
        parkingLot.unparkVehicleFromParkingLot(car1, parkingTicketNumber);

        System.out.println(stringFiller);

        // unpark vehicle car2
        parkingTicketNumber = parkingLot.getParkingTicketNumber(car1);
        parkingLot.unparkVehicleFromParkingLot(car2, parkingTicketNumber);

        System.out.println(stringFiller);

        // park vehicle car3
        parkingLot.parkVehicleOnParkingLot(car3);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // park vehicle motorcycle1
        parkingLot.parkVehicleOnParkingLot(motorcycle1);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // park vehicle motorcycle2
        parkingLot.parkVehicleOnParkingLot(motorcycle2);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // park vehicle car2
        parkingLot.parkVehicleOnParkingLot(car2);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // park vehicle bus3
        parkingLot.parkVehicleOnParkingLot(bus3);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);


        // unpark vehicle motorcycle1
        parkingTicketNumber = parkingLot.getParkingTicketNumber(motorcycle1);
        parkingLot.unparkVehicleFromParkingLot(motorcycle1, parkingTicketNumber);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // park vehicle motorcycle1
        parkingLot.parkVehicleOnParkingLot(motorcycle1);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // unpark vehicle - vehicle not parked, ticket not valid
        parkingTicketNumber = "000100";
        System.out.printf("Entered parking ticket: %s\n", parkingTicketNumber);
        parkingLot.unparkVehicleFromParkingLot(car1, parkingTicketNumber);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // unpark vehicle - vehicle not parked, another vehicle parked by this ticket
        parkingTicketNumber = "000006";
        System.out.printf("Entered parking ticket: %s\n", parkingTicketNumber);
        parkingLot.unparkVehicleFromParkingLot(car1, parkingTicketNumber);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        // unpark vehicle - vehicle parked, ticket not valid
        parkingTicketNumber = "000200";
        System.out.printf("Entered parking ticket: %s\n", parkingTicketNumber);
        parkingLot.unparkVehicleFromParkingLot(motorcycle1, parkingTicketNumber);
        TimeUnit.SECONDS.sleep(timeout);

        System.out.println(stringFiller);

        System.out.println("Java8: List of parked vehicles");
        System.out.println(parkingLot.getListOfVehiclesJava8());

        System.out.println(stringFiller);

        String type = "car";
        System.out.println("Java 8: List of parked vehicles by type: " + type);
        System.out.println(parkingLot.getListOfVehiclesJava8(type));

        System.out.println(stringFiller);

        //java8
        String searchCriteria = "BC";
        System.out.printf("Java8: Is at least one vehicle's license plates start from %s: %b\n", searchCriteria, parkingLot.isOneVehicleRegistered(searchCriteria));
        System.out.println();
        searchCriteria = "Ivan";
        System.out.printf("Java8: Are all vehicles' owners' equal to names '%s': %b\n", searchCriteria, parkingLot.areAllVehiclesOwners(searchCriteria));
        System.out.println();
        searchCriteria = "motorcycle";
        System.out.printf("Java8: Are all vehicles' type equal to '%s': %b\n", searchCriteria, parkingLot.areNoneVehiclesTypes(searchCriteria));

        System.out.println(stringFiller);

        System.out.println("Java8: Sorted list os unique license plates of parked vehicles");
        System.out.println(parkingLot.getListOfSortedLicensePlatesJava8());

        System.out.println(stringFiller);

        System.out.println("Java8: Vehicles list according to duration staying on a parking lot");
        System.out.println(parkingLot.getSortedListAccordingToDurationJava8());

    }
}