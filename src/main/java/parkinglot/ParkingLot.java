package parkinglot;

import parkinglot.Enums.PaymentStatus;
import parkinglot.Enums.SpotStatus;
import parkinglot.Exceptions.ParkingLotIsEmptyException;
import parkinglot.Exceptions.ParkingLotIsFullException;
import parkinglot.Exceptions.ParkingTicketNumberNotFoundException;
import parkinglot.Exceptions.VehicleNotFoundOnParkingLotException;

import java.util.*;
import java.util.regex.Pattern;

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
        //parkingTickets = new ArrayList<ParkingTicket>();
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
        return freeSpots == 0;
    }

    public String parkVehicleOnParkingLot(AbstractVehicle vehicle) {



        if (isFull()) {
            throw new ParkingLotIsFullException("Unfortunately, parking lot is full. Try again later.\n");
        } else {

            System.out.printf("--- Parking vehicle of type %s with license plates %s ---\n",
                    vehicle.getVehicleType(),
                    vehicle.getLicensePlates());

            freeSpots--;

            int freeSpot = checkFirstFreeParkingSpot();

            parkingSpots.get(freeSpot).parkVehicleOnParkingSpot(vehicle);

            vehicles.set(freeSpot, vehicle);

            parkingSpotsTicketsMap.put(Integer.toString(parkingSpots.get(freeSpot).getSpotNumber()), new ParkingTicket());

            return displayTicket("Park", freeSpot);
        }
    }

    public String unparkVehicleFromParkingLot(AbstractVehicle vehicle, String parkingTicketNumber) {

        boolean ticketFound = false;
        boolean vehicleFound = false;
        int spotToClean = 0;

        for (int i = 0; i < capacity; i++) {
            if (vehicles.contains(vehicle)) {
                vehicleFound = true;
                break;
            }
        }

        for (int i = 0; i < capacity; i++) {
            if (parkingSpotsTicketsMap.get(Integer.toString(i)).getParkingTicketNumber()
                    .equalsIgnoreCase(parkingTicketNumber)) {

                spotToClean = i;
                ticketFound = true;
                break;
            }
        }

        if (!ticketFound) {
            throw new ParkingTicketNumberNotFoundException("Ticket number has not been found.\n");
        } else {

            System.out.printf("--- Unparking vehicle of type %s with license plates %s ---\n",
                    vehicle.getVehicleType(),
                    vehicle.getLicensePlates());

            freeSpots++;

            parkingSpots.get(spotToClean).unparkVehicleFromParkingSpot(vehicle);
            vehicles.set(spotToClean, null);

            parkingSpotsTicketsMap.get(Integer.toString(spotToClean)).setPaymentStatus(
                    PaymentStatus.PAYED.toString());
            parkingSpotsTicketsMap.get(Integer.toString(spotToClean)).setExitTime();
        }

        String parkingInfo = displayTicket("Unpark", spotToClean);

        parkingSpotsTicketsMap.put(Integer.toString(parkingSpots.get(spotToClean).getSpotNumber()), null);

        return parkingInfo;
    }

    private int checkFirstFreeParkingSpot() {

        int freeSpot = -1;

        for (int i = 0; i < capacity; i++) {
            if (parkingSpots.get(i).getSpotStatus().equals(SpotStatus.FREE.toString())) {
                freeSpot = i;
                break;
            }
        }

        return freeSpot;
    }

    public String getParkingTicketNumber(AbstractVehicle vehicle) throws VehicleNotFoundOnParkingLotException {

        System.out.printf("--- Searching parking ticket number for %s with license plates %s ---\n",
                vehicle.getVehicleType(),
                vehicle.getLicensePlates());

        if (parkingSpotsTicketsMap.entrySet().isEmpty()) {
            throw new ParkingLotIsEmptyException("There are no vehicles on parking lot.\n");
        }

        if(!vehicles.contains(vehicle)) {
            throw new VehicleNotFoundOnParkingLotException("Vehicle has not been found on parking lot.\n");
        }

        Iterator iterator = parkingSpotsTicketsMap.entrySet().iterator();

        int i = 0;
        while (i < parkingSpotsTicketsMap.entrySet().size()) {

            if (parkingSpotsTicketsMap.get(Integer.toString(parkingSpots.get(i).getSpotNumber())) != null) {
                if (vehicles.get(i).getLicensePlates().equals(vehicle.getLicensePlates())) {
                    System.out.println("Ticket has been found.\n");
                    return parkingSpotsTicketsMap.get(Integer.toString(i)).getParkingTicketNumber();
                }
            }
            i++;
        }
        throw new ParkingTicketNumberNotFoundException("Ticket has not been found.\n");
    }

    private String displayTicket(String action, int spot) {

        String tmp = "*** Parking ticket ***\n";

        tmp += "Parking spot: " +
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
                parkingSpotsTicketsMap.get(Integer.toString(spot)).getPaymentStatus() +
                "\n";

        if (action.equals("Park")) {
            tmp += "License plates: " +
                    vehicles.get(spot).getLicensePlates() +
                    "\n" +
                    "Vehicle type: " +
                    vehicles.get(spot).getVehicleType() +
                    "\n" ;
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
    public String getListOfVehicles() {
        ArrayList<String> vehiclesList = new ArrayList<String>();
        for (int i = 0; i < capacity; i++) {
            if (vehicles.get(i) != null) {
                vehiclesList.add(vehicles.get(i).getLicensePlates());
            }
        }

        return String.join(", ", vehiclesList);
    }

    // retrieve list of vehicles filtered by type (e.g. car, bike, lorry etc)
    public String getListOfVehicles(String type) {
        ArrayList<String> vehiclesList = new ArrayList<String>();

        for (int i = 0; i < capacity; i++) {
            if ((vehicles.get(i) != null) && (vehicles.get(i).getVehicleType().equalsIgnoreCase(type))) {
                vehiclesList.add(vehicles.get(i).getLicensePlates());
            }
        }

        return String.join(", ", vehiclesList);
    }

    // Sort vehicles list according to duration it is staying on a parking lot
    public String sortAccordingToDuration() {

        Map<String, String> spotsEntranceTimeMap = new HashMap<>(); // hashmap <spotNumber, entrance time>
        List<String> licensePlatesList = new ArrayList<>(); // list of license plates sorted according to entrance time
        List<String> entranceTimeSortedList;
        Iterator<String> iterator;
        String spotNumber;

        for (int i = 0; i < capacity; i++) {
            spotNumber = Integer.toString(parkingSpots.get(i).getSpotNumber());

            if (parkingSpotsTicketsMap.get(spotNumber) != null) {

                spotsEntranceTimeMap.put(spotNumber, parkingSpotsTicketsMap.get(spotNumber).getEntranceTime());
            }
        }

        entranceTimeSortedList = new ArrayList<>(spotsEntranceTimeMap.values()); // Entrance time values' list

        Collections.sort(entranceTimeSortedList); // entrance time values' list sorted in ascending order

        iterator = entranceTimeSortedList.iterator();

        while (iterator.hasNext()) {
            // get parking spot number from vehicles list by spot number <key> taken from spotsEntranceTimeMap
            // according to entrance time <value>
            spotNumber = getKey(spotsEntranceTimeMap, iterator.next());

            licensePlatesList.add(vehicles.get(Integer.parseInt(spotNumber)).getLicensePlates());
        }

        return String.join(", ", licensePlatesList);
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    // Check if at least one vehicle in your list corresponds to some search criteria
    // (e.g. vehicle is registered in Lviv (plate number starts with ‘BC’))
    // Check if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)
    // Check if none of the vehicles from list corresponds to some search criteria (e.g. vehicle type is motorcycle)
    public boolean checkVehicle(String searchCriteria) {

        // 1st symbol: t - type, o - owner, p - plates
        // 2nd symbol: ! - none of, * - all of, + - at least one of

        String searchByTypePattern = "^t.+$";
        String searchByOwnerPattern = "^o.+$";
        String searchByPlatesPattern = "^p.+$";


        String searchOnePattern = "^.\\+.+$";
        String searchAllPattern = "^.\\*.+$";
        String searchNonePattern = "^.!.+$";

        int numberOfBusyParkingSpots = 0; // all busy parking spots
        int numberOfBusyParkingSpotsCrspndToSearchCriteria = 0; // all busy parking spots corresponding to search criteria

        String searchCriteriaPattern;

        if (Pattern.matches(searchByTypePattern, searchCriteria.toLowerCase())) {
            for (int i = 0; i < capacity; i++) {
                if (vehicles.get(i) != null) {
                    numberOfBusyParkingSpots++;
                    searchCriteriaPattern = "^" + searchCriteria.substring(2) + "$";
                    if (Pattern.matches(searchCriteriaPattern.toLowerCase(),
                            vehicles.get(i).getVehicleType().toLowerCase())) {
                        numberOfBusyParkingSpotsCrspndToSearchCriteria++;
                    }
                }
            }
        }

        if (Pattern.matches(searchByOwnerPattern, searchCriteria.toLowerCase())) {
            for (int i = 0; i < capacity; i++) {
                if (vehicles.get(i) != null) {
                    numberOfBusyParkingSpots++;
                    searchCriteriaPattern = "^" + searchCriteria.substring(2) + "$";
                    if (Pattern.matches(searchCriteriaPattern.toLowerCase(),
                            vehicles.get(i).getOwnerName().toLowerCase())) {
                        numberOfBusyParkingSpotsCrspndToSearchCriteria++;
                    }
                }
            }
        }

        if (Pattern.matches(searchByPlatesPattern, searchCriteria.toLowerCase())) {
            for (int i = 0; i < capacity; i++) {
                if (vehicles.get(i) != null) {
                    numberOfBusyParkingSpots++;
                    searchCriteriaPattern = "^" + searchCriteria.substring(2) + ".+$";
                    if (Pattern.matches(searchCriteriaPattern.toLowerCase(),
                            vehicles.get(i).getLicensePlates().toLowerCase())) {
                        numberOfBusyParkingSpotsCrspndToSearchCriteria++;
                    }
                }
            }
        }

        if (Pattern.matches(searchAllPattern, searchCriteria)) {
            return numberOfBusyParkingSpots == numberOfBusyParkingSpotsCrspndToSearchCriteria;
        }

        if (Pattern.matches(searchOnePattern, searchCriteria)) {
            return numberOfBusyParkingSpotsCrspndToSearchCriteria > 0;
        }

        if (Pattern.matches(searchNonePattern, searchCriteria)) {
            return numberOfBusyParkingSpotsCrspndToSearchCriteria == 0;
        }

        return false;
    }

    //Traverse vehicle list, collect all unique registration numbers,
    // sort them alphabetically and print them to console using comma as a delimiter
    public String getSortedLicensePlates() {

        Set<String> uniqueLicensePlates = new TreeSet<String>();

        // fill sorted set of unique license plates
        for (int i = 0; i < capacity; i++) {
            if (vehicles.get(i) != null) {
                uniqueLicensePlates.add(vehicles.get(i).getLicensePlates());
            }
        }

        return String.join(", ", uniqueLicensePlates);
    }
}