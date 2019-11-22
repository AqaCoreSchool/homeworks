package parkinglot;

import com.sun.source.tree.UsesTree;
import parkinglot.Enums.PaymentStatus;
import parkinglot.Enums.SpotStatus;
import parkinglot.Enums.VehicleType;
import parkinglot.Exceptions.ParkingLotIsFullException;
import parkinglot.Exceptions.ParkingTicketNumberNotFoundException;
import parkinglot.Exceptions.VehicleNotFoundOnParkingLotException;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParkingLot {

    private String name;
    private String address;
    private int capacity;
    private int freeSpots = 0;

    private List<ParkingSpot> parkingSpots;
    private List<AbstractVehicle> vehicles;
    private Map<String, ParkingTicket> parkingSpotsTicketsMap;

    // initiate Parking Lot
    ParkingLot(String name, String address, int capacity) {

        //System.out.println("Initialization of new parking lot with capacity: " + capacity);
        this.name = name;
        this.address = address;
        this.capacity = capacity;

        // initialize empty array list for vehicles and tree set for parking spop
        parkingSpots = new ArrayList<>(capacity);
        vehicles = new ArrayList<>(capacity);
        parkingSpotsTicketsMap = new HashMap<>();

        for (int i = 0; i < capacity; i++) {

            parkingSpots.add(new ParkingSpot(i));
            parkingSpotsTicketsMap.put(Integer.toString(i), null);

            freeSpots++;

            vehicles.add(null);
        }
    }

    private boolean isFull() {
        if (freeSpots != 0) {
            return false;
        }
        throw new ParkingLotIsFullException("Parking lot is full. Try again later.");
    }

    public void parkVehicleOnParkingLot(AbstractVehicle vehicle) {

        System.out.printf("> Parking vehicle with license plates %s\n",
                vehicle.getLicensePlates());

        try {
            if (!isFull()) {

                freeSpots--;

                int freeSpot = checkFirstFreeParkingSpot();

                parkingSpots.get(freeSpot).parkVehicleOnParkingSpot(vehicle);

                vehicles.set(freeSpot, vehicle);

                parkingSpotsTicketsMap.put(Integer.toString(parkingSpots.get(freeSpot).getSpotNumber()),
                        new ParkingTicket());

                String parkingInfo = displayTicket("Park", freeSpot, vehicle);

                System.out.println(parkingInfo);
            }
        } catch (ParkingLotIsFullException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isVehiclePresentedInListOfVehicles(AbstractVehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            throw new VehicleNotFoundOnParkingLotException("Vehicle has not been found on parking lot.");
        }
        return vehicles.contains(vehicle);
    }

    private boolean isTicketFound(String parkingTicketNumber) {

        for (int i = 0; i < capacity; i++) {

            //System.out.println(parkingSpotsTicketsMap.get(Integer.toString(i)));
            if (parkingSpotsTicketsMap.get(Integer.toString(i)) != null) {
                if (parkingSpotsTicketsMap.get(Integer.toString(i)).getParkingTicketNumber()
                        .equalsIgnoreCase(parkingTicketNumber)) {
                    return true;
                }
            }
        }
        throw new ParkingTicketNumberNotFoundException("Ticket number has not been found.");
    }

    public void unparkVehicleFromParkingLot(AbstractVehicle vehicle, String parkingTicketNumber) {

        System.out.printf("> Unparking vehicle with license plates %s\n",
                vehicle.getLicensePlates());

        try {
            if (isVehiclePresentedInListOfVehicles(vehicle)) {
                try {
                    if (isTicketFound(parkingTicketNumber)) {

                        int spotToClean = 0;

                        for (int i = 0; i < capacity; i++) {
                            if (parkingSpotsTicketsMap.get(Integer.toString(i)) != null) {
                                if (parkingSpotsTicketsMap.get(Integer.toString(i)).getParkingTicketNumber()
                                        .equalsIgnoreCase(parkingTicketNumber)) {

                                    spotToClean = i;
                                    break;
                                }
                            }
                        }

                        freeSpots++;

                        parkingSpots.get(spotToClean).unparkVehicleFromParkingSpot(vehicle);
                        vehicles.set(spotToClean, null);

                        parkingSpotsTicketsMap.get(Integer.toString(spotToClean)).setPaymentStatus(
                                PaymentStatus.PAYED.toString());
                        parkingSpotsTicketsMap.get(Integer.toString(spotToClean)).setExitTime();


                        String parkingInfo = displayTicket("Unpark", spotToClean, vehicle);

                        parkingSpotsTicketsMap.put(Integer.toString(parkingSpots.get(spotToClean).getSpotNumber()), null);

                        System.out.println(parkingInfo);
                    }
                } catch (ParkingTicketNumberNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (VehicleNotFoundOnParkingLotException e) {
            System.out.println(e.getMessage());
        }
    }

    // Java8
    private int checkFirstFreeParkingSpot() {

        ParkingSpot freeSpot = parkingSpots.stream()
                .filter(ps -> ps.getSpotStatus().equalsIgnoreCase(SpotStatus.FREE.toString()))
                .findFirst()
                .get();

        return freeSpot.getSpotNumber();
    }

    public String getParkingTicketNumber(AbstractVehicle vehicle) {

        System.out.printf("> Searching ticket for vehicle with license plates %s\n",
                vehicle.getLicensePlates());

        String parkingTicketNumber = null;

        try {
            parkingTicketNumber = getParkingTicketNumberFromMap(vehicle);
        } catch (ParkingTicketNumberNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return parkingTicketNumber;
    }

    private String getParkingTicketNumberFromMap(AbstractVehicle vehicle) {

        for (int i = 0; i < capacity; i++) {

            if (vehicles.get(i) != null) {
                if (vehicles.get(i).getLicensePlates().equals(vehicle.getLicensePlates())) {
                    String parkingTicketNumber = parkingSpotsTicketsMap.get(Integer.toString(i)).getParkingTicketNumber();
                    System.out.printf("Searched ticket is: %s\n\n", parkingTicketNumber);
                    return parkingTicketNumber;
                }
            }
        }
        throw new ParkingTicketNumberNotFoundException("No tickets have been found related to the vehicle.");
    }

    private String displayTicket(String action, int spot, AbstractVehicle vehicle) {

        String tmp = "";

        tmp += "### Parking ticket ###\n" +
                "Parking spot: " +
                parkingSpots.get(spot).getSpotNumber() +
                "\n" +
                "Parking spot status: " +
                parkingSpots.get(spot).getSpotStatus() +
                "\n" +
                "Ticket number: " +
                parkingSpotsTicketsMap.get(Integer.toString(spot)).getParkingTicketNumber() +
                "\n" +
                "Entrance time: " +
                parkingSpotsTicketsMap.get(Integer.toString(spot)).getEntranceTime() +
                "\n";

        if (action.equals("Unpark")) {
            tmp += "Exit time: " +
                    parkingSpotsTicketsMap.get(Integer.toString(spot)).getExitTime() +
                    "\n";
        }

        tmp += "Status: " +
                parkingSpotsTicketsMap.get(Integer.toString(spot)).getPaymentStatus();

        if (action.equals("Park")) {
            tmp += "\nLicense plates: " +
                    vehicles.get(spot).getLicensePlates() +
                    "\n" +
                    "Vehicle type: " +
                    vehicles.get(spot).getVehicleType();
        }
        return tmp;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // retrieve list of vehicles on a parking lot
    // java8 - Method Reference
    public String getListOfVehiclesJava8() {

        List<String> vehiclesList = vehicles.stream()
                .filter(Objects::nonNull)
                .map(AbstractVehicle::getLicensePlates)
                .collect(Collectors.toList());

        return String.join(", ", vehiclesList);
    }

    // retrieve list of vehicles filtered by type (e.g. car, bike, lorry etc)
    // java8
    public String getListOfVehiclesJava8(String type) {
        List<String> vehiclesList = vehicles.stream()
                .filter(vehicle -> vehicle != null)
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(type))
                .map(vehicle -> vehicle.getLicensePlates())
                .collect(Collectors.toList());

        return String.join(", ", vehiclesList);
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    // java8
    public String getSortedListAccordingToDurationJava8() {

        Map<String, String> spotsEntranceTimeMap; // hashmap <spotNumber, entrance time>
        List<String> sortedEntranceTimesList;
        List<String> sortedSpotsList;
        List<String> sortedLicensePlatesList;

        List<Integer> spots = parkingSpots.stream().
                map(parkingSpot -> parkingSpot.getSpotNumber())
                .collect(Collectors.toList());

        spotsEntranceTimeMap = spots.stream()
                .filter(spot -> parkingSpotsTicketsMap.get(Integer.toString(spot)) != null)
                .collect(Collectors.toMap(spot -> Integer.toString(spot),
                        spot -> parkingSpotsTicketsMap.get(Integer.toString(spot)).getEntranceTime()));

        // gei list of sorted entrance times
        sortedEntranceTimesList = spotsEntranceTimeMap.values().stream()
                .distinct()
                .collect(Collectors.toList());

        Collections.sort(sortedEntranceTimesList, (t1, t2) -> t1.compareTo(t2));

        sortedSpotsList =  sortedEntranceTimesList.stream()
                .map(plate -> getKey(spotsEntranceTimeMap, plate))
                .collect(Collectors.toList());

        sortedLicensePlatesList = sortedSpotsList.stream()
                .map(spot -> vehicles.get(Integer.parseInt(spot)).getLicensePlates())
                .collect(Collectors.toList());

        return String.join(", ", sortedLicensePlatesList);
    }

    // Check if at least one vehicle in your list corresponds to some search criteria
    // (e.g. vehicle is registered in Lviv (plate number starts with ‘BC’))
    //java8
    public boolean isOneVehicleRegistered(String searchCriteria) {
        return vehicles.stream().anyMatch(vehicle -> vehicle.getLicensePlates().startsWith(searchCriteria));
    }
    // Check if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)
    //java8
    public boolean areAllVehiclesOwners(String searchCriteria) {
        return vehicles.stream().allMatch(vehicle -> vehicle.getOwnerName().contains(searchCriteria));
    }
    // Check if none of the vehicles from list corresponds to some search criteria (e.g. vehicle type is motorcycle)
    //java8
    public boolean areNoneVehiclesTypes(String searchCriteria) {
        return vehicles.stream().noneMatch(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(searchCriteria));
    }

    //Traverse vehicle list, collect all unique registration numbers,
    // sort them alphabetically and print them to console using comma as a delimiter
    // java8
    public String getListOfSortedLicensePlatesJava8() {

        List<String> sortedPlatesList = vehicles.stream()
                .filter(vehicle -> vehicle != null)
                .map(vehicle -> vehicle.getLicensePlates())
                .distinct()
                .collect(Collectors.toList());

        Collections.sort(sortedPlatesList, (lp1, lp2) -> lp1.compareTo(lp2));

        return String.join(", ", sortedPlatesList);

    }
}
