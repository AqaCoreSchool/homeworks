package ParkingLot;

import java.util.*;

class DateComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getDateIn().compareTo(v2.getDateOut());
    }
}

public class Main {

    public final static int lotCount = 100;
    public static int freeLots = 100;
    public static List<String> lots = new ArrayList();
    public static List<String> uniqueNumbers = new ArrayList();
    public static List<Vehicle> carAll = new ArrayList();

    public static void printVehicleList(List list) {
        list.stream().forEach(System.out::println);
    }

    public static void filterByNumber(String template) {
        for (Vehicle vehicle : carAll) {
            if (vehicle.getNumber().substring(0, 2).equals(template)) {
                System.out.println(vehicle);
            }
        }
    }

    public static void filterByOwner(String ownerSearch) {
        for (Vehicle vehicle : carAll) {
            if (vehicle.getOwner().equalsIgnoreCase("Ivan Ivanov")) {
                System.out.println(vehicle);
            }
        }
    }

    public static void sortByDurations(List cars) {
        Collections.sort(carAll, new DateComparator());
        Collections.reverse(carAll);
        Main.printVehicleList(carAll);
    }

    public static void waitConsole() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void deleteDuplicates() {
        Set<String> set = new HashSet<>(lots);
        uniqueNumbers.addAll(set);
        uniqueNumbers.sort(String::compareTo);
        Main.printVehicleList(uniqueNumbers);
    }

    public static void main(String[] args) {
        System.out.println();
        Employees s1 = new SecurityStaff();
        s1.setStaff("Ivan", 250);
        System.out.println(s1.toString());
        Employees admin1 = new Admin("Petro", 80);
        System.out.println(admin1.toString());

        Vehicle v1 = new Truck("Ivan Ivanov", "АА 6789 АК");
        waitConsole();
        Vehicle v2 = new Truck("Petro Pupkin", "ВС 3454 РП");
        waitConsole();
        Vehicle v3 = new Truck("Vasya Ivanov", "АА 1111 ТИ");
        waitConsole();
        Vehicle v4 = new Truck("Ivan Ivanov", "ВС 2222 ТИ");
        waitConsole();
        Vehicle v5 = new Truck("Ivan Ivanov", "АА 3333 ТИ");
        waitConsole();
        Vehicle v6 = new Truck("Ivan Ivanov", "АА 4444 ТИ");
        waitConsole();
        Vehicle v7 = new Truck("Ivan Ivanov", "АА 5555 ТИ");
        waitConsole();
        Vehicle v8 = new Truck("Ivan Ivanov", "АА 5556 ТИ");
        carAll.add(v1);
        carAll.add(v2);
        carAll.add(v3);
        carAll.add(v4);
        carAll.add(v5);
        carAll.add(v6);
        carAll.add(v7);
        carAll.add(v8);
        System.out.println("Results of method CheckIn/CheckOut");
        v1.checkIn();
        v2.checkIn();
        v3.checkIn();
        v1.checkOut(v1);
        v4.checkIn();

        System.out.println("Results of method which prints all vehicles");
        printVehicleList(carAll);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Method which prints, vehicles with numbers, like ВС **** **. Please, enter first 2 letters of vehicle number");
        String numberForSearch = scanner.nextLine();
        filterByNumber(numberForSearch);

        System.out.println("Method which prints all vehicles, which owners are .... Please enter owner's name");
        String ownerForSearch = scanner.nextLine();
        filterByNumber(ownerForSearch);

        System.out.println("Revers sorting by durations");
        ;
        sortByDurations(carAll);

        System.out.println("Vehicle list, with unique numbers, sorted alphabetically");
        Main.deleteDuplicates();

    }
}
