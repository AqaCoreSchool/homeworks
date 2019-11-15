package ParkingLot;

import java.util.*;

public class VehicleParking {


    final static int LOT_COUNT = 100;
    static int freeLots = 100;
    static String pattern = "([А-Я][А-Я](\\s)[0-9][0-9][0-9][0-9](\\s)[А-Я][А-Я])";
    static List<String> lots = new ArrayList();
    private static List<String> uniqueNumbers = new ArrayList();
    static List<Vehicle> carAll = new ArrayList();
    static Map<String, Vehicle> carNumLotMap = new HashMap<>();

    static void printVehicleList(List list) {

        list.stream().forEach(System.out::println);
    }

    static void filterByNumber(String template) {
        for (Vehicle vehicle : carAll) {
            if (vehicle.getNumber().substring(0, 2).equals(template)) {
                System.out.println(vehicle);
            }
        }
    }

    static boolean checkIfExistNumber(String template) {
        for (Vehicle vehicle : carAll) {
            if (vehicle.getNumber().substring(0, 2).equals(template)) {
                return true;
            }
        }
        return false;
    }

    static void waitConsole() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void deleteDuplicatesByNumber() {
        Set<String> set = new HashSet<>(lots);
        uniqueNumbers.addAll(set);
        uniqueNumbers.sort(String::compareTo);
        printVehicleList(uniqueNumbers);
    }


    static void filterByOwner(String ownerSearch) {
        for (Vehicle vehicle : carAll) {
            if (vehicle.getOwner().contains(ownerSearch)) {
                System.out.println(vehicle);
            }
        }
    }

    static boolean isAllOwners(String ownerSearch) {
        for (Vehicle vehicle : carAll) {
            if (!vehicle.getOwner().contains(ownerSearch)) {
                return false;
            }
        }
        return true;
    }

    static boolean isAllTypes(String typeSearch) {
        for (Vehicle vehicle : carAll) {
            if (vehicle.getType().contains(typeSearch)) {
                return false;
            }
        }
        return true;
    }

    static void checkType(String vehicleType) {
        for (Vehicle vehicle : carAll) {
            if (vehicle.getType().equalsIgnoreCase(vehicleType)) {
                System.out.println(vehicle);
            }
        }
    }

    static void sortByDurations() {
        Collections.sort(carAll, new DateComparator());
        Collections.reverse(carAll);
        printVehicleList(carAll);
    }


    static void addCarToMap(String number, Vehicle vehicle) {
        carNumLotMap.put(number, vehicle);
    }

    public void deleteDuplicatesSort(Map carNumLotMap) {
    }

    public void getCarByNumber() {
        for (int i = 0; i < VehicleParking.lots.size(); i++) {

        }
    }
}


