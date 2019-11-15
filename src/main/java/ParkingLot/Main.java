package ParkingLot;

import java.util.Scanner;

import static ParkingLot.VehicleParking.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AbstractEmployees s1 = new SecurityStaff();
        s1.setStaff("Ivan", 250);
        System.out.println(s1.toString());
        AbstractEmployees admin1 = new Admin("Petro", 80);
        System.out.println(admin1.toString());

        AbstractVehicle v1 = new Truck("Ivan Franko", "АА 6789 КА");
        VehicleParking.waitConsole();
        AbstractVehicle v2 = new Car("Taras Shevchenko", "АВ 3454 КВ");
        VehicleParking.waitConsole();
        AbstractVehicle v3 = new Truck("Lesya Ukrainka", "АТ 1122211 ТИ");
        VehicleParking.waitConsole();
        AbstractVehicle v4 = new Car("Grigoriy Scovoroda", "ВС 2222 АВ");
        VehicleParking.waitConsole();
        AbstractVehicle v5 = new Truck("Ostap Vyshny", "ВВ 3333 АК");
        VehicleParking.waitConsole();
        AbstractVehicle v6 = new Car("Ivan Petrov", "ВІ 44444 КЛ");
        VehicleParking.waitConsole();
        AbstractVehicle v7 = new Truck("Ivan Petrenko", "АА 5555 ОП");
        VehicleParking.waitConsole();
        AbstractVehicle v8 = new Truck("Stephen King", "АА 5556 ТИ");
        AbstractVehicle v9 = new Truck("George Martin", "АППА 5556 ТИ");
        AbstractVehicle v10 = new Truck("Joanne Rowling", "АА 5556 ТИ");
        AbstractVehicle v11 = new Truck("Taras Kvas", "АА 5556 ТИ");
        AbstractVehicle v12 = new Truck("Ostap Ivanov", "АВ 5556 ТИ");
        AbstractVehicle v13 = new Truck("Tim Barton", "АА 5586 ТИ");
        AbstractVehicle v14 = new Truck("Ivan Ivanov", "АА 5556 ТИ");
        AbstractVehicle v15 = new Truck("Ivan Ivanov", "АА 5556 ТИ");
        System.out.println("Results of method CheckIn/CheckOut");
        v1.checkIn(v1);
        v2.checkIn(v2);
        v3.checkIn(v3);
        v4.checkIn(v4);
        v5.checkIn(v5);
        v6.checkIn(v6);
        v7.checkIn(v7);
        v8.checkIn(v8);
        v9.checkIn(v9);
        v10.checkIn(v10);
        System.out.println("\n");
        v1.checkOut(v1);
        v2.checkOut(v2);
        v3.checkOut(v3); //incorrect Vehicle number, car wasn't check

        System.out.println("\nResult of printing map\n");
        System.out.println(numberVehicleMap.values().toString());

        System.out.println("\nResults of method which prints all vehicles\n"); // Task #1 Add possibility for user to retrieve list of vehicles on a parking lot
        VehicleParking.printVehicleList(vehicleList);

        System.out.println("\nMethod which prints all vehicles, which type are ... Please enter type: Car or Truck\n");
        String typeForSearch = scanner.nextLine();
        checkType(typeForSearch); //Task #2 Add possibility for user to retrieve list of vehicles filtered by type (e.g. car, bike, lorry etc)

        System.out.println("\nRevers sorting by durations\n"); // Task #3 Sort vehicles list according to duration it is staying on a parking lot
        sortByDurations();

        System.out.println("\nMethod which prints, vehicles with numbers, like ВС **** **. Please, enter first 2 letters of vehicle number\n");
        String numberForSearch = scanner.nextLine();
        filterByNumber(numberForSearch);
        System.out.println("\nMethod which, checking if at least one vehicle in list corresponds to some search criteria.\n (e.g. vehicle number starts with ‘BC’))\n");
        System.out.println(isNumberExist(numberForSearch)); // Task #4

        System.out.println("\nMethod which prints all vehicles, which owners are .... Please enter owner's name");
        String ownerForSearch = scanner.nextLine();
        filterByOwner(ownerForSearch);

        System.out.println("\nCheck if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)\n");
        System.out.println(isAllOwners(ownerForSearch)); // Task #5 Check if all vehicles correspond to some search criteria (e.g. name of Vehicle owner is Ivan)

        System.out.println("\nCheck if none of the vehicles from list corresponds to some search criteria (e.g. vehicle type is motorcycle)\n");
        typeForSearch = scanner.nextLine();
        System.out.println(isAllTypes(typeForSearch)); // Task #6

        System.out.println("\nVehicle list, with unique numbers, sorted alphabetically\n"); // Task #7
        getCarByUniqueNumber(); // list of all vehicles and list of numbers(just fo checking)
    }
}
