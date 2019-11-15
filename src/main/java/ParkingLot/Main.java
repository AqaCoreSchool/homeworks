package ParkingLot;

import java.util.Scanner;

import static ParkingLot.VehicleParking.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employees s1 = new SecurityStaff();
        s1.setStaff("Ivan", 250);
        System.out.println(s1.toString());
        Employees admin1 = new Admin("Petro", 80);
        System.out.println(admin1.toString());

        Vehicle v1 = new Truck("Ivan Ivanov", "АА 6789 АК");
        VehicleParking.waitConsole();
        Vehicle v2 = new Car("Ivan Pupkin", "ВС 3454 РП");
        VehicleParking.waitConsole();
        Vehicle v3 = new Truck("Ivan Ivanov", "ТМ 1111 ТИ");
        VehicleParking.waitConsole();
        Vehicle v4 = new Car("Ivan Ivanov", "ВС 2222 АВ");
        VehicleParking.waitConsole();
        Vehicle v5 = new Truck("Ivan Shevchenko", "АА 3333 АК");
        VehicleParking.waitConsole();
        Vehicle v6 = new Car("Ivan Franko", "АА 4444 КЛ");
        VehicleParking.waitConsole();
        Vehicle v7 = new Truck("Ivan Ivanov", "АА 5555 ОП");
        VehicleParking.waitConsole();
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
        v1.checkIn(v1);
        v2.checkIn(v2);
        v3.checkIn(v3);
        v1.checkOut(v1);
        v2.checkOut(v1);
        v4.checkIn(v4);
        System.out.println("\nResult of printing map\n");
        System.out.println(carNumLotMap.values().toString());

        System.out.println("\nResults of method which prints all vehicles\n"); // Task #1 Add possibility for user to retrieve list of vehicles on a parking lot
        VehicleParking.printVehicleList(carAll);

        System.out.println("\nMethod which prints all vehicles, which type are ... Please enter type: Car or Truck\n");
        String typeForSearch = scanner.nextLine();
        checkType(typeForSearch); //Task #2 Add possibility for user to retrieve list of vehicles filtered by type (e.g. car, bike, lorry etc)

        System.out.println("\nRevers sorting by durations\n"); // Task #3 Sort vehicles list according to duration it is staying on a parking lot
        sortByDurations();

        System.out.println("\nMethod which prints, vehicles with numbers, like ВС **** **. Please, enter first 2 letters of vehicle number\n");
        String numberForSearch = scanner.nextLine();
        filterByNumber(numberForSearch);
        System.out.println("\nMethod which, checking if at least one vehicle in list corresponds to some search criteria.\n (e.g. vehicle number starts with ‘BC’))\n");
        System.out.println(checkIfExistNumber(numberForSearch)); // Task #4

        System.out.println("\nMethod which prints all vehicles, which owners are .... Please enter owner's name");// Task #5 Check if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)
        String ownerForSearch = scanner.nextLine();
        filterByOwner(ownerForSearch);

        System.out.println("\nCheck if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)\n");
        System.out.println(isAllOwners(ownerForSearch));

        System.out.println(isAllTypes(typeForSearch));
        System.out.println("\nVehicle list, with unique numbers, sorted alphabetically\n");
        //   deleteDuplicates(carNumLotMap);
    }
}
