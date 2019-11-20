package parkinglot;

import parkinglot.Enums.PaymentStatus;
import parkinglot.Enums.SpotStatus;
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


//    private int checkFirstFreeParkingSpot() {
//
//        int freeSpot = -1;
//
//        for (int i = 0; i < capacity; i++) {
//            if (parkingSpots.get(i).getSpotStatus().equals(SpotStatus.FREE.toString())) {
//                freeSpot = i;
//                break;
//            }
//        }
//
//        return freeSpot;
//    }

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
    public String getListOfVehicles() {
        List<String> vehiclesList = new ArrayList<String>();
        for (int i = 0; i < capacity; i++) {
            if (vehicles.get(i) != null) {
                vehiclesList.add(vehicles.get(i).getLicensePlates());
            }
        }

        return String.join(", ", vehiclesList);
    }

    // java8 - Method Reference
    public String getListOfVehiclesJava8() {

        List<String> vehiclesList = vehicles.stream()
                .filter(Objects::nonNull)
                .map(AbstractVehicle::getLicensePlates)
                .collect(Collectors.toList());

        return String.join(", ", vehiclesList);
    }

    // retrieve list of vehicles filtered by type (e.g. car, bike, lorry etc)
    public String getListOfVehicles(String type) {
        List<String> vehiclesList = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            if ((vehicles.get(i) != null) && (vehicles.get(i).getVehicleType().equalsIgnoreCase(type))) {
                vehiclesList.add(vehicles.get(i).getLicensePlates());
            }
        }

        return String.join(", ", vehiclesList);
    }

    // java8
    public String getListOfVehiclesJava8(String type) {
        List<String> vehiclesList = vehicles.stream()
                .filter(vehicle -> vehicle != null)
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(type))
                .map(vehicle -> vehicle.getLicensePlates())
                .collect(Collectors.toList());

        return String.join(", ", vehiclesList);
    }

    // Sort vehicles list according to duration it is staying on a parking lot
    public String getSortedListAccordingToDuration() {

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

    // java8
    public String getSortedListAccordingToDurationJava8() {

        Map<String, String> spotsEntranceTimeMap; // hashmap <spotNumber, entrance time>
        List<String> sortedEntranceTimesList;
        List<String> sortedSpotsList;
        List<String> sortedLicensePlatesList;

        List<Integer> spots = parkingSpots.stream().
                map(parkingSpot -> parkingSpot.getSpotNumber())
                .collect(Collectors.toList());

        //System.out.println(spots);

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
    public String getListOfSortedLicensePlates() {

        Set<String> uniqueLicensePlates = new TreeSet<String>();

        // fill sorted set of unique license plates
        for (int i = 0; i < capacity; i++) {
            if (vehicles.get(i) != null) {
                uniqueLicensePlates.add(vehicles.get(i).getLicensePlates());
            }
        }

        return String.join(", ", uniqueLicensePlates);
    }

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
