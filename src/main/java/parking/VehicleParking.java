package parking;

import java.util.*;

class VehicleParking {


    final static int LOT_COUNT = 100;
    static int freeLots = 100;
    static String pattern = "([А-Я][А-Я](\\s)[0-9][0-9][0-9][0-9](\\s)[А-Я][А-Я])";
    static List<String> lotsList = new ArrayList();
    static List<AbstractVehicle> uniqueNumbersList = new ArrayList();
    static List<AbstractVehicle> vehicleList = new ArrayList();
    static List<String> sortedVehicleList = new ArrayList();
    static Map<String, AbstractVehicle> numberVehicleMap = new HashMap<>();
    static Map<String, AbstractVehicle> sortedMap = new HashMap<>();

    static void printVehicleList(List list) {
        list.stream().forEach(System.out::println);
    }

    static void filterByNumber(String template) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getNumber().substring(0, 2).equals(template)) {
                System.out.println(vehicle);
            }
        }
    }

    static boolean isNumberExist(String template) {
        for (AbstractVehicle vehicle : vehicleList) {
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

    static void filterByOwner(String ownerSearch) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getOwner().contains(ownerSearch)) {
                System.out.println(vehicle);
            }
        }
    }

    static boolean isAllOwners(String ownerSearch) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (!vehicle.getOwner().contains(ownerSearch)) {
                return false;
            }
        }
        return true;
    }

    static boolean isAllTypes(String typeSearch) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getVehicleType().contains(typeSearch)) {
                return false;
            }
        }
        return true;
    }

    static void checkType(String vehicleType) {
        for (AbstractVehicle vehicle : vehicleList) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                System.out.println(vehicle);
            }
        }
    }

    static void sortByDurations() {
        Collections.sort(vehicleList, new DateComparator());
        Collections.reverse(vehicleList);
        printVehicleList(vehicleList);
    }


    static void addCarToMap(String number, AbstractVehicle vehicle) {
        numberVehicleMap.put(number, vehicle);
    }

    static void getCarByUniqueNumber() {
        SortedSet<String> keys = new TreeSet<>(numberVehicleMap.keySet());
        StringBuilder builder = new StringBuilder();
        for (String key : keys) {
            builder.append(numberVehicleMap.get(key).toString()).append(", ");
        }
        System.out.println(builder.toString());
        System.out.println(keys); // need to delete late, just for checking
    }


}


