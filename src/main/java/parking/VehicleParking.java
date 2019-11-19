package parking;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VehicleParking {


    final static int LOT_COUNT = 100;
    public static int freeLots = 100;
    public static String pattern = "([А-Я][А-Я](\\s)[0-9][0-9][0-9][0-9](\\s)[А-Я][А-Я])";
    public static List<String> lotsList = new ArrayList();
    public static List<AbstractVehicle> uniqueNumbersList = new ArrayList();
    public static List<AbstractVehicle> vehicleList = new ArrayList();
    public static List<String> sortedNumbersList = new ArrayList();
    public static List<String> ticketsList = new ArrayList();
    public static Map<String, AbstractVehicle> numberVehicleMap = new HashMap<>();
    public static Map<String, AbstractVehicle> sortedMap = new HashMap<>();

    // Task #1 Add possibility for user to retrieve list of vehicles on a parking lot
    public static void printList(List list) {
        list.stream().forEach(System.out::println);
    }

    //Task #2 Add possibility for user to retrieve list of vehicles filtered by type (e.g. car, bike, lorry etc)
    public static void filterByType(String vehicleType) {
        vehicleList.stream().filter(o -> o.getVehicleType().equals(vehicleType)).forEach(System.out::println);
    }

    // Task #3 Sort vehicles list according to duration it is staying on a parking lot
    public static void sortByDurations() {
        // vehicleList.stream().sorted((o1, o2) -> new DateComparator()).forEach(System.out::println);
        List<AbstractVehicle> sortedUsers = vehicleList.stream()
                .sorted(Comparator.comparing(AbstractVehicle::getDateIn).reversed())
                .collect(Collectors.toList());
        printList(sortedUsers);
    }

    /* Task #4   Check if at least one vehicle in your list corresponds to some
     search criteria (e.g. vehicle is registered in Lviv (plate number starts with ‘BC’))
     */
    public static boolean isNumberExist(String number) {
        return vehicleList.stream().filter(o -> o.getNumber().substring(0, 2).equals(number)).findFirst().isPresent();
    }

    // Task #5    Check if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)
    public static boolean isAllOwners(String ownerSearch) {
        return vehicleList.stream().allMatch(o -> o.getOwner().equals(ownerSearch));
    }

    // Task #6  Check if none of the vehicles from list corresponds to some search criteria (e.g. vehicle type is motorcycle)
    public static boolean isAllTypes(String typeSearch) {
        return (vehicleList.stream().noneMatch(o -> o.getVehicleType().equals(typeSearch)));
    }

    /* Task #7  Traverse vehicle list, collect all unique registration numbers,
    sort them alphabetically and print them to console using comma as a delimiter
     */
    public static String getCarByUniqueNumber() {

        sortedNumbersList = vehicleList.stream().map(vehicleList -> vehicleList.getNumber()).distinct().sorted().collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for (String key : sortedNumbersList) {
            builder.append(numberVehicleMap.get(key).toShortString()).append(", ");
        }
        System.out.println(sortedNumbersList); // need to delete late, just for checking
        return (builder.toString());
    }

    public static void waitConsole() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void filterByOwner(String ownerSearch) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getOwner().contains(ownerSearch)) {
                System.out.println(vehicle);
            }
        }
    }

    public static void filterByNumber(String template) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getNumber().substring(0, 2).equals(template)) {
                System.out.println(vehicle);
            }
        }
    }

    public static void addCarToMap(String number, AbstractVehicle vehicle) {
        numberVehicleMap.put(number, vehicle);
    }

    public boolean isNumberCorrect(String number) {
        try {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(number);
            if (m.matches()) {
                return true;
            } else {
                System.out.println(number + " - this is wrong format of vehicle number ");
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("Number is empty. You can not add vehicle without number ");
            return false;
        }
    }
}


