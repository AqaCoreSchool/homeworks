package parking;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehicleParking {


    final static int LOT_COUNT = 100;
    public static int freeLots = 100;
    public static String pattern = "([А-Я][А-Я](\\s)[0-9][0-9][0-9][0-9](\\s)[А-Я][А-Я])";
    public static List<String> lotsList = new ArrayList();
    public static List<AbstractVehicle> uniqueNumbersList = new ArrayList();
    public static List<AbstractVehicle> vehicleList = new ArrayList();
    public static List<String> sortedVehicleList = new ArrayList();
    public static Map<String, AbstractVehicle> numberVehicleMap = new HashMap<>();
    public static Map<String, AbstractVehicle> sortedMap = new HashMap<>();

    public static void printVehicleList(List list) {
        list.stream().forEach(System.out::println);
    }

    public static void filterByNumber(String template) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getNumber().substring(0, 2).equals(template)) {
                System.out.println(vehicle);
            }
        }
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

    public static boolean isNumberExist(String template) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getNumber().substring(0, 2).equals(template)) {
                return true;
            }
        }
        return false;
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

    public static boolean isAllOwners(String ownerSearch) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (!vehicle.getOwner().contains(ownerSearch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllTypes(String typeSearch) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getVehicleType().contains(typeSearch)) {
                return false;
            }
        }
        return true;
    }

    public static void checkType(String vehicleType) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                System.out.println(vehicle);
            }
        }
    }

    public static void sortByDurations() {
        Collections.sort(vehicleList, new DateComparator());
        Collections.reverse(vehicleList);
        printVehicleList(vehicleList);
    }


    public static void addCarToMap(String number, AbstractVehicle vehicle) {
        numberVehicleMap.put(number, vehicle);
    }

    public static void getCarByUniqueNumber() {
        SortedSet<String> keys = new TreeSet<>(numberVehicleMap.keySet());
        StringBuilder builder = new StringBuilder();
        for (String key : keys) {
            builder.append(numberVehicleMap.get(key).toString()).append(", ");
        }
        System.out.println(builder.toString());
        System.out.println(keys); // need to delete late, just for checking
    }
}


